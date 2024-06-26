import React, { useState } from 'react';
import { useDispatch } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import { loginUser } from '../features/users/usersSlice';
import { AppDispatch } from '../app/store';
import '../styles/LoginForm.css';

const UserLogin: React.FC = () => {
  const [username, setUsername] = useState<string>('');
  const dispatch = useDispatch<AppDispatch>();
  const navigate = useNavigate();

  const handleSubmit = (event: React.FormEvent) => {
    event.preventDefault();
    if (username) {
      dispatch(loginUser(username)).then((action) => {
        if (loginUser.fulfilled.match(action)) {
          navigate('/numbers');
        } else {
          // in case something fails
        }
      });
    }
  };

  return (
    <div className="login-container">
      <form onSubmit={handleSubmit} className="login-form">
        <label>
          Username:
          <input
            type="text"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            placeholder="Enter your username"
          />
        </label>
        <button type="submit">Login</button>
      </form>
    </div>
  );
};

export default UserLogin;