import React from 'react';
import { useLocation, Routes, Route } from 'react-router-dom';
import AdminSidebar from './Pages/Admin/AdminSidebar'; 
import UserSidebar from './Components/StaffSidebar'; // Updated import for UserSidebar
import Navbar from './Components/Navbar'; 
import SignIn from './Pages/Signin'; 
import SignUp from './Pages/Signup'; 
import AdminDashboard from './Pages/Admin/AdminDashboard'; 
// import EmployeeStatusDashboard from './Pages/Admin/EmployeeStatusDashboard';
import Scheduling from './Pages/Admin/Scheduling';
import StaffDashboard from './Pages/User/StaffDashboard'; 
import MySchedule from './Pages/User/MySchedule'; 
import TimeOffRequestPage from './Pages/User/TimeOffRequestPage'; 
import SwiftSwapping from './Pages/User/SwiftSwapping';
import UserProfile from './Pages/User/UserProfile';
//import Notification from './Components/Notification';

//import ProfileSettings from './pages/Staff/ProfileSettings';

const drawerWidth = 50; // Adjust as necessary

const AppContent = ({ mode, toggleColorMode }) => {
  const location = useLocation();

  console.log("Current path:", location.pathname); // Debugging path

  // Determine which sidebar to display
  const isAdminPath = location.pathname.startsWith('/Admin');
  const isUserPath = location.pathname.startsWith('/User'); // Changed from isStaffPath to isUserPath
  
  const SidebarComponent = isAdminPath ? AdminSidebar : (isUserPath ? UserSidebar : null); // Updated to use UserSidebar

  // Show Navbar only on login and signup pages
  const showNavbar = location.pathname === '/' || location.pathname === '/Signup';
  
  return (
    <div style={{ display: 'flex' }}>
      {showNavbar && <Navbar mode={mode} toggleColorMode={toggleColorMode} />}
      
      {SidebarComponent && (
        <SidebarComponent darkTheme={mode === 'dark'} toggleDarkTheme={toggleColorMode} />
      )}
      
      <main
        style={{
          flexGrow: 1,
          padding: '16px', // Adjust padding as needed
          marginLeft: SidebarComponent ? `${drawerWidth}px` : '0',
        }}
      >
        <Routes>
          <Route path="/" element={<SignIn />} />
          <Route path="/Signup" element={<SignUp />} />
          <Route path="/AdminDashboard" element={<AdminDashboard />} />
          {/* <Route path="/Admin/EmployeeStatusDashboard" element={<EmployeeStatusDashboard />} /> */}
          <Route path="/User/StaffDashboard" element={<StaffDashboard />} />
          <Route path="/User/my-schedule" element={<MySchedule />} />
          <Route path="/User/time-off-requests" element={<TimeOffRequestPage />} />
          <Route path="/User/shift-swapping" element={<SwiftSwapping />} />
          {/* <Route path="/Staff/profile-settings" element={<ProfileSettings />} /> */}
          <Route path="/UserProfile" element={<UserProfile />} />
          <Route path="/Admin/Scheduling" element={<Scheduling />} />
          {/* Add other routes as needed */}
        </Routes>
      </main>
    </div>
  );
};

export default AppContent;
