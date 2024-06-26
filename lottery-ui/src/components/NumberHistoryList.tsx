import React from 'react';
import { useSelector } from 'react-redux';
import { RootState } from '../app/store';
import { Number } from '../features/numbers/numbersSlice';
import {formatDateTime} from "../utils/functions";

const NumberHistoryList: React.FC = () => {
  const user = useSelector((state: RootState) => state.user.user);

  if (!user) {
    return <div>No user found</div>;
  }

  const sortedNumbers = [...user.numbers].sort((a, b) => new Date(b.generatedAt).getTime() - new Date(a.generatedAt).getTime());

  console.log('sorted numbers', sortedNumbers);
  return (
    <div>
      <h2>Generated Numbers</h2>
      {sortedNumbers.length === 0 ? (
        <p>No numbers generated yet.</p>
      ) : (
        <ul>
          {sortedNumbers.map((num: Number) => (
            <li key={num.id}>
              {num.number} (generated at: {formatDateTime(new Date(num.generatedAt))})
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default NumberHistoryList;