import React, { useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import { generateNumber } from '../features/numbers/numbersSlice';
import NumberHistoryList from '../components/NumberHistoryList';
import NumberGenerator from '../components/NumberGenerator';
import { RootState, AppDispatch } from '../app/store';
import '../styles/NumberHistory.css';
import { capitalize } from '../utils/functions';


const NumberHistory: React.FC = () => {
  const user = useSelector((state: RootState) => state.user.user);
  const dispatch = useDispatch<AppDispatch>();
  const navigate = useNavigate();

  useEffect(() => {
    if (!user) {
      navigate('/');
    }
  }, [user, navigate]);

  const handleGenerate = () => {
    if (user) {
      dispatch(generateNumber(user.id));
    }
  };

  if (!user) {
    return null; // Or a loading indicator
  }

  return (
    <div className="number-history-container">
      <h1>Welcome, {capitalize(user.name)}</h1>
      <div className="generator">
        <NumberGenerator onGenerate={handleGenerate} />
      </div>
      <div className="history">
        <NumberHistoryList />
      </div>
    </div>
  );
};

export default NumberHistory;