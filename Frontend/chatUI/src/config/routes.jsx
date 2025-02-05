import React from 'react'
import {Routes, Route} from 'react-router';
import App from '../App';

const AppRoutes = () => {
  return (
    <div>
      <Routes>
        <Route path="/" element={<App />} />
        <Route path="/chat" element={<h1>This is chat app</h1>} />
        <Route path="/about" element={<h1>This is about page</h1>} />
        <Route path="*" element={<h1>Page 404 Not found</h1>} />

    </Routes>
    </div>
  )
}

export default AppRoutes
