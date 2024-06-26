import React, { useEffect } from 'react';
import { useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import LoginForm from '../components/LoginForm';
import { RootState } from '../app/store';

const UserLogin: React.FC = () => {
  const user = useSelector((state: RootState) => state.user.user);
  const navigate = useNavigate();

  useEffect(() => {
    if (user) {
      navigate('/numbers');
    }
  }, [user, navigate]);

  return (
    <div>
      <h1>Login</h1>
      <LoginForm />
    </div>
  );
};

export default UserLogin;