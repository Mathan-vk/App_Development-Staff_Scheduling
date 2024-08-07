import React, { useState, useEffect } from 'react';
import {
  Box,
  Typography,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
  Tabs,
  Tab,
  TextField,
  Button,
  FormControl,
  InputLabel,
  Select,
  MenuItem,
  Grid,
  Modal
} from '@mui/material';

// Mock Data (replace with API calls or a database)
const roles = ['Doctor', 'Nurse', 'Surgeon', 'Anesthesiologist'];
const operations = ['Operation A', 'Operation B', 'Operation C'];
const operationTheatres = ['Theatre 1', 'Theatre 2', 'Theatre 3'];
const shifts = ['Morning', 'Afternoon', 'Evening', 'Night'];

// Sample staff data
const staffData = [
  { id: 1, name: 'Dr. John Doe', role: 'Doctor', availability: { '2024-07-29': ['Morning', 'Afternoon'] }, specialization: 'Cardiology' },
  { id: 2, name: 'Jane Smith', role: 'Nurse', availability: { '2024-07-29': ['Afternoon', 'Evening'] }, specialization: 'Pediatrics' },
  { id: 3, name: 'Dr. Mike Johnson', role: 'Surgeon', availability: { '2024-07-29': ['Morning', 'Evening'] }, specialization: 'Orthopedics' },
  { id: 4, name: 'Emily Davis', role: 'Anesthesiologist', availability: { '2024-07-29': ['Night'] }, specialization: 'Anesthesia' }
];

const Scheduling = () => {
  const [selectedDate, setSelectedDate] = useState(new Date());
  const [scheduleData, setScheduleData] = useState({
    today: [],
    previous: [],
    tomorrow: [],
    special: []
  });
  const [tabValue, setTabValue] = useState(0);
  const [editingSchedule, setEditingSchedule] = useState([]);
  const [selectedStaff, setSelectedStaff] = useState(null);
  const [shift, setShift] = useState('');
  const [roleFilter, setRoleFilter] = useState('');
  const [modalOpen, setModalOpen] = useState(false);

  useEffect(() => {
    initializeSchedule();
  }, []);

  const initializeSchedule = () => {
    const today = formatDate(new Date());
    setScheduleData({
      today: generateSchedule(today),
      previous: generateSchedule('2024-07-28'),
      tomorrow: generateSchedule('2024-07-30'),
      special: generateOperationSchedule('2024-07-30')
    });
  };

  const formatDate = (date) => {
    return date.toISOString().split('T')[0];
  };

  const generateSchedule = (date) => {
    return staffData.map(staff => ({
      ...staff,
      shifts: staff.availability[date] || []
    }));
  };

  const generateOperationSchedule = (date) => {
    return staffData.filter(staff => staff.role === 'Surgeon' || staff.role === 'Nurse')
      .map(staff => ({
        ...staff,
        operation: operations[Math.floor(Math.random() * operations.length)],
        theatre: operationTheatres[Math.floor(Math.random() * operationTheatres.length)]
      }));
  };

  const handleTabChange = (event, newValue) => {
    setTabValue(newValue);
    if (newValue === 2) { // Tab for tomorrow
      setEditingSchedule(generateSchedule(formatDate(new Date(new Date().getTime() + 24 * 60 * 60 * 1000))));
    }
  };

  const handleChange = (event) => {
    const { name, value } = event.target;
    setSelectedStaff(prev => ({ ...prev, [name]: value }));
  };

  const handleShiftChange = (event) => {
    setShift(event.target.value);
  };

  const handleSave = () => {
    // Save logic for schedule
    console.log('Saving schedule', editingSchedule);
    // Update staff data and close modal or refresh
    setModalOpen(false);
  };

  const handleEdit = (staff) => {
    setSelectedStaff(staff);
    setModalOpen(true);
  };

  const handleAddShift = () => {
    if (selectedStaff && shift) {
      const updatedSchedule = editingSchedule.map(staff => {
        if (staff.id === selectedStaff.id) {
          return {
            ...staff,
            shifts: [...staff.shifts, shift]
          };
        }
        return staff;
      });
      setEditingSchedule(updatedSchedule);
      setShift('');
    }
  };

  const renderScheduleTable = (schedule, isSpecial = false, isEditable = false, showShifts = false) => (
    <TableContainer component={Paper} sx={{ mt: 2 }}>
      <Table>
        <TableHead>
          <TableRow>
            <TableCell>Name</TableCell>
            <TableCell>Role</TableCell>
            {showShifts && <TableCell>Shifts</TableCell>}
            {isSpecial && (
              <>
                <TableCell>Operation</TableCell>
                <TableCell>Theatre</TableCell>
              </>
            )}
            {isEditable && <TableCell>Action</TableCell>}
          </TableRow>
        </TableHead>
        <TableBody>
          {schedule.length > 0 ? (
            schedule.map((row, index) => (
              <TableRow key={index}>
                <TableCell>{row.name}</TableCell>
                <TableCell>{row.role}</TableCell>
                {showShifts && <TableCell>{row.shifts.join(', ')}</TableCell>}
                {isSpecial && (
                  <>
                    <TableCell>{row.operation}</TableCell>
                    <TableCell>{row.theatre}</TableCell>
                  </>
                )}
                {isEditable && (
                  <TableCell>
                    <Button variant="contained" color="primary" onClick={() => handleEdit(row)}>Edit</Button>
                  </TableCell>
                )}
              </TableRow>
            ))
          ) : (
            <TableRow>
              <TableCell colSpan={isSpecial ? 5 : (isEditable ? 4 : (showShifts ? 3 : 2))} align="center">
                No data available
              </TableCell>
            </TableRow>
          )}
        </TableBody>
      </Table>
    </TableContainer>
  );

  return (
    <Box sx={{ p: 3 }}>
      <Typography variant="h4" gutterBottom>
        Hospital Scheduling Dashboard
      </Typography>
      <Tabs value={tabValue} onChange={handleTabChange} aria-label="schedule tabs">
        <Tab label="Today's Schedule" />
        <Tab label="Previous Days' Schedule" />
        <Tab label="Tomorrow's Schedule" />
        <Tab label="Special Operation Schedule" />
      </Tabs>
      {tabValue === 0 && (
        <>
          <Typography variant="h6" gutterBottom>
            Today's Schedule
          </Typography>
          {shifts.map(shift => (
            <Box key={shift}>
              <Typography variant="h6" gutterBottom>
                {shift} Shift
              </Typography>
              {renderScheduleTable(scheduleData.today.filter(staff => staff.shifts.includes(shift)), false, true, true)}
            </Box>
          ))}
        </>
      )}
      {tabValue === 1 && renderScheduleTable(scheduleData.previous)}
      {tabValue === 2 && (
        <Box>
          {renderScheduleTable(editingSchedule, false, true, true)}
          <Grid container spacing={2} sx={{ mt: 2 }}>
            <Grid item xs={12} sm={6}>
              <FormControl fullWidth>
                <InputLabel>Shift</InputLabel>
                <Select
                  value={shift}
                  onChange={handleShiftChange}
                  label="Shift"
                >
                  {shifts.map((shift) => (
                    <MenuItem key={shift} value={shift}>{shift}</MenuItem>
                  ))}
                </Select>
              </FormControl>
            </Grid>
            <Grid item xs={12} sm={6}>
              <Button variant="contained" color="primary" onClick={handleAddShift} sx={{ mt: 2 }}>
                Add Shift
              </Button>
            </Grid>
          </Grid>
        </Box>
      )}
      {tabValue === 3 && renderScheduleTable(scheduleData.special, true)}

      {/* Edit Schedule Modal */}
      <Modal open={modalOpen} onClose={() => setModalOpen(false)}>
        <Box sx={{ p: 3, bgcolor: 'background.paper', borderRadius: 1, boxShadow: 3, maxWidth: 600, mx: 'auto', mt: 10 }}>
          <Typography variant="h6" gutterBottom>
            Edit Schedule for {selectedStaff?.name}
          </Typography>
          <TextField
            fullWidth
            margin="normal"
            label="Name"
            name="name"
            value={selectedStaff?.name || ''}
            onChange={handleChange}
            disabled
          />
          <TextField
            fullWidth
            margin="normal"
            label="Role"
            name="role"
            value={selectedStaff?.role || ''}
            onChange={handleChange}
            disabled
          />
          <TextField
            fullWidth
            margin="normal"
            label="Specialization"
            name="specialization"
            value={selectedStaff?.specialization || ''}
            onChange={handleChange}
            disabled
          />
          <Grid container spacing={2} sx={{ mt: 2 }}>
            <Grid item xs={12} sm={6}>
              <FormControl fullWidth>
                <InputLabel>Shift</InputLabel>
                <Select
                  value={shift}
                  onChange={handleShiftChange}
                  label="Shift"
                >
                  {shifts.map((shift) => (
                    <MenuItem key={shift} value={shift}>{shift}</MenuItem>
                  ))}
                </Select>
              </FormControl>
            </Grid>
            <Grid item xs={12} sm={6}>
              <Button variant="contained" color="primary" onClick={handleSave} sx={{ mt: 2 }}>
                Save
              </Button>
            </Grid>
          </Grid>
        </Box>
      </Modal>
    </Box>
  );
};

export default Scheduling;
