import React from 'react';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import {Provider} from 'react-redux';
import store from './app/store';
import UserLogin from './views/UserLogin';
import NumberHistory from './views/NumberHistory';

const App: React.FC = () => {
  return (
    <Provider store={store}>
      <Router>
        <Routes>
          <Route path="/" element={<UserLogin/>}/>
          <Route path="/numbers" element={<NumberHistory/>}/>
        </Routes>
      </Router>
    </Provider>
  );
};

export default App;