import {createAsyncThunk, createSlice, PayloadAction} from '@reduxjs/toolkit';
import axiosInstance from '../../api/axiosInstance';
import { addNumber } from '../users/usersSlice';


export interface Number {
  id: number;
  number: number;
  generatedAt: string;
}

interface NumbersState {
  numbers: Number[];
  status: 'idle' | 'loading' | 'succeeded' | 'failed';
  error: string | null;
}

const initialState: NumbersState = {
  numbers: [],
  status: 'idle',
  error: null,
};

export const fetchNumbers = createAsyncThunk(
  'numbers/fetchNumbers',
  async (userId: number) => {
    const response = await axiosInstance.get<Number[]>(`/api/users/${userId}`);
    return response.data;
  }
);

export const generateNumber = createAsyncThunk(
  'numbers/generateNumber',
  async (userId: number, { dispatch }) => {
    const response = await axiosInstance.post<Number>(`/api/numbers/generate`, { userId });
    console.log('new number: ', response.data)
    dispatch(addNumber(response.data));
    return response.data;
  }
);

const numbersSlice = createSlice({
  name: 'numbers',
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder
      .addCase(fetchNumbers.pending, (state) => {
        state.status = 'loading';
      })
      .addCase(fetchNumbers.fulfilled, (state, action: PayloadAction<Number[]>) => {
        state.status = 'succeeded';
        state.numbers = action.payload;
      })
      .addCase(fetchNumbers.rejected, (state, action) => {
        state.status = 'failed';
        state.error = action.error.message || null;
      })
      .addCase(generateNumber.fulfilled, (state, action: PayloadAction<Number>) => {
        state.numbers.push(action.payload);
      });
  },
});

export default numbersSlice.reducer;