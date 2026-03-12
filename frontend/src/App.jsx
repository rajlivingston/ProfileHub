import { useState, useEffect } from 'react'
import './App.css'

function App() {
  const [students, setStudents] = useState([])
  const [loading, setLoading] = useState(true)
  const [formData, setFormData] = useState({
    name: '',
    degree: '',
    destination: ''
  })

  // Fetch all students
  const fetchStudents = async () => {
    setLoading(true)
    try {
      const response = await fetch('/students')
      const data = await response.json()
      setStudents(data)
    } catch (error) {
      console.error('Error fetching students:', error)
    } finally {
      setLoading(false)
    }
  }

  useEffect(() => {
    fetchStudents()
  }, [])

  // Handle Input Change
  const handleInputChange = (e) => {
    const { name, value } = e.target
    setFormData(prev => ({ ...prev, [name]: value }))
  }

  // Create Student
  const handleSubmit = async (e) => {
    e.preventDefault()
    try {
      const response = await fetch('/students', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(formData)
      })
      if (response.ok) {
        setFormData({ name: '', degree: '', destination: '' })
        fetchStudents()
      }
    } catch (error) {
      console.error('Error creating student:', error)
    }
  }

  // Delete Student
  const handleDelete = async (id) => {
    if (window.confirm('Are you sure you want to delete this profile?')) {
      try {
        const response = await fetch(`/students/${id}`, {
          method: 'DELETE'
        })
        if (response.ok) {
          fetchStudents()
        }
      } catch (error) {
        console.error('Error deleting student:', error)
      }
    }
  }

  // Handle File Upload
  const handleFileUpload = async (id, file, type) => {
    if (!file) return;

    const formData = new FormData();
    formData.append('file', file);

    const endpoint = type === 'resume' ? `/students/${id}/upload-resume` : `/students/${id}/upload-visume`;

    try {
      const response = await fetch(endpoint, {
        method: 'POST',
        body: formData
      });

      if (response.ok) {
        alert(`${type.charAt(0).toUpperCase() + type.slice(1)} uploaded successfully!`);
        fetchStudents();
      } else {
        alert(`Failed to upload ${type}.`);
      }
    } catch (error) {
      console.error(`Error uploading ${type}:`, error);
      alert(`Error uploading ${type}.`);
    }
  }

  return (
    <div className="app-container">
      <header>
        <h1>ProfileHub</h1>
        <p>Premium Student Profile Management System</p>
      </header>

      <div className="card">
        <h2>Add Student Profile</h2>
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label>Full Name</label>
            <input 
              name="name" 
              placeholder="e.g. John Doe" 
              value={formData.name}
              onChange={handleInputChange}
              required
            />
          </div>
          <div className="form-group">
            <label>Degree</label>
            <input 
              name="degree" 
              placeholder="e.g. B.Tech Computer Science" 
              value={formData.degree}
              onChange={handleInputChange}
              required
            />
          </div>
          <div className="form-group">
            <label>Target Destination</label>
            <input 
              name="destination" 
              placeholder="e.g. Software Engineer at Google" 
              value={formData.destination}
              onChange={handleInputChange}
              required
            />
          </div>
          <button type="submit" className="btn-primary">
            <span>+</span> Create Profile
          </button>
        </form>
      </div>

      <div className="profiles-section">
        <h2>Student Profiles</h2>
        {loading ? (
          <div className="loading-spinner">
            <div className="dot-flashing"></div>
          </div>
        ) : students.length > 0 ? (
          <div className="student-grid">
            {students.map(student => (
              <div key={student.id} className="card student-card">
                <div className="student-info">
                  <h3>{student.name}</h3>
                  <p><strong>Degree:</strong> {student.degree}</p>
                  <p><strong>Goal:</strong> {student.destination}</p>
                  <div className="file-status">
                    <span className={`status-badge ${student.resumePath ? 'active' : ''}`}>
                      {student.resumePath ? '📄 Resume' : '🚫 No Resume'}
                    </span>
                    <span className={`status-badge ${student.visumePath ? 'active' : ''}`}>
                      {student.visumePath ? '🎥 Visume' : '🚫 No Visume'}
                    </span>
                  </div>
                </div>
                <div className="upload-actions">
                  <div className="upload-item">
                    <label htmlFor={`resume-${student.id}`} className="btn-secondary">
                      Upload Resume
                    </label>
                    <input 
                      id={`resume-${student.id}`}
                      type="file" 
                      accept=".pdf,.doc,.docx"
                      onChange={(e) => handleFileUpload(student.id, e.target.files[0], 'resume')}
                      hidden
                    />
                  </div>
                  <div className="upload-item">
                    <label htmlFor={`visume-${student.id}`} className="btn-secondary">
                      Upload Visume
                    </label>
                    <input 
                      id={`visume-${student.id}`}
                      type="file" 
                      accept="video/*"
                      onChange={(e) => handleFileUpload(student.id, e.target.files[0], 'visume')}
                      hidden
                    />
                  </div>
                </div>
                <div className="student-actions">
                  <button className="btn-danger" onClick={() => handleDelete(student.id)}>
                    Delete Profile
                  </button>
                </div>
              </div>
            ))}
          </div>
        ) : (
          <div className="empty-state">
            <p>No profiles found. Start by adding one above!</p>
          </div>
        )}
      </div>
    </div>
  )
}

export default App
