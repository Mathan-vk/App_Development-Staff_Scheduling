import React from 'react';
import { Link } from 'react-router-dom';
import '../Asset/CSS/Navbar.css';
import MenuIcon from '@mui/icons-material/Menu';

const Navbar = ({ toggleSidebar }) => {
  return (
    <nav className="navbar">
      <button className="menu-btn" onClick={toggleSidebar}><MenuIcon /></button>
      <Link to="/" className="logo">Staff Scheduler</Link>
      <ul className="nav-links">
        <li><Link to="/">Home</Link></li>
        <li><Link to="/about">About</Link></li>
      </ul>
      <div className="auth-links">
        <Link to="/signin">Sign In</Link>
        <Link to="/signup">Sign Up</Link>
      </div>
    </nav>
  );
};

export default Navbar;
