import {createAsyncThunk, createSlice, PayloadAction} from '@reduxjs/toolkit';
import axiosInstance from '../../api/axiosInstance';
import { Number} from "../numbers/numbersSlice";


export interface User {
  id: number;
  name: string;
  numbers: Number[];
}

interface UserState {
  user: User | null;
  status: 'idle' | 'loading' | 'succeeded' | 'failed';
  error: string | null;
}

const initialState: UserState = {
  user: null,
  status: 'idle',
  error: null,
};

export const loginUser = createAsyncThunk(
  'user/loginUser',
  async (username: string) => {
    console.log(`username: ${username}`)
    const response = await axiosInstance.post<User>('/api/users', {userName: username}, {
      headers: {'Content-Type': 'application/json'},
    });
    return response.data;
  }
);

const userSlice = createSlice({
  name: 'user',
  initialState,
  reducers: {
    addNumber: (state, action: PayloadAction<Number>) => {
      if (state.user) {
        state.user.numbers.push(action.payload);
      }
    },
  },
  extraReducers: (builder) => {
    builder
      .addCase(loginUser.pending, (state) => {
        state.status = 'loading';
      })
      .addCase(loginUser.fulfilled, (state, action: PayloadAction<User>) => {
        state.status = 'succeeded';
        state.user = action.payload;
      })
      .addCase(loginUser.rejected, (state, action) => {
        state.status = 'failed';
        state.error = action.error.message || null;
      });
  },
});

export const { addNumber } = userSlice.actions;

export default userSlice.reducer;