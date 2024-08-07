import React from 'react';
import { Link } from 'react-router-dom';
//import '../Asset/CSS/Sidebar.css';

const Sidebar = ({ sidebarOpen, closeSidebar, isAdmin }) => {
  return (
    <>
      <div className={`sidebar ${sidebarOpen ? 'open' : ''}`}>
        <div className="sidebar-header">
          <h2>Menu</h2>
          <button className="closebtn" onClick={closeSidebar}>&times;</button>
        </div>
        <div className="sidebar-content">
          <Link to="/" onClick={closeSidebar}>Home</Link>
          <Link to="/about" onClick={closeSidebar}>About</Link>
          {isAdmin ? (
            <>
              <Link to="/admin/dashboard" onClick={closeSidebar}>Admin Dashboard</Link>
            </>
          ) : (
            <>
              <Link to="/user/dashboard" onClick={closeSidebar}>User Dashboard</Link>
            </>
          )}
        </div>
      </div>
      {sidebarOpen && <div className="overlay" onClick={closeSidebar}></div>}
    </>
  );
};

export default Sidebar;
