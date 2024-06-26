import { configureStore } from '@reduxjs/toolkit';
import userReducer from '../features/users/usersSlice';
import numbersReducer from '../features/numbers/numbersSlice';

export const store = configureStore({
  reducer: {
    user: userReducer,
    numbers: numbersReducer,
  },
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;

export default store;