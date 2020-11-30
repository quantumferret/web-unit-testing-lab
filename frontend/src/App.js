import React from 'react';
import './App.css';

const ws = new WebSocket('ws://localhost:1235/ws');

const App = ({ }) => {
  const [totalUsers, setTotalUsers] = React.useState(0);
  const [notes, setNotes] = React.useState(['test']);
  const [note, setNote] = React.useState('');

  React.useEffect(() => {
    // do something when component mounts
    ws.addEventListener('message', (stringMessage) => {
      console.log(stringMessage.data); //incoming from server
      const newNotes = notes.slice(); // copy from item 0
      newNotes.push(stringMessage.data);
      setNotes(newNotes);
    });
  }, []);

  const handleSubmit = () => {
    console.log(note);
    ws.send(note);
    setNote('');
  };

  const deleteFunction = (i) => {
    console.log('Should delete item at index ', i);
  };

  return (
    <div className="App">
      <header className="user-counter">
        {totalUsers} : Users
      </header>
      <div>
        <input value={note} onChange={e => setNote(e.target.value)} />
        <button onClick={handleSubmit}>Submit</button>
      </div>
      <div className="notes">
        {notes.map((note, i) => (
          <div className="note-item" key={i}>
            <div>{i}</div>
            <div>{note}</div>
            <button onClick={() => deleteFunction(i)}>Delete</button>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;
