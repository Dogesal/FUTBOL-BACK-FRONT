import React from 'react';
import FutbolistasTable from './components/FutbolistasTable';
import './App.css';

const App: React.FC = () => {
    return (
        <div className="App">
            <header className="App-header">
                <h1>Lista de Futbolistas</h1>
                <FutbolistasTable />
            </header>
        </div>
    );
};

export default App;