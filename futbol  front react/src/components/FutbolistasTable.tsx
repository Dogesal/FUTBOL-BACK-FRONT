import React, { useState, useEffect } from 'react';
import { Futbolista } from '../types/Futbolista';

const FutbolistasTable: React.FC = () => {
    const [futbolistas, setFutbolistas] = useState<Futbolista[]>([]);
    const [loading, setLoading] = useState<boolean>(true);
    const [error, setError] = useState<string | null>(null);
    const [currentPage, setCurrentPage] = useState<number>(0);
    const [totalPages, setTotalPages] = useState<number>(0); 

    const pageSize = 2; // Tamaño de página

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch(`http://127.0.0.1:8001/futbolistas?page=${currentPage}&size=${pageSize}`);
                if (!response.ok) {
                    throw new Error('Error fetching data');
                }
                const data = await response.json();
                setFutbolistas(data.content);
                setTotalPages(data.totalPages); // Actualizar el estado de totalPages
            } catch (err) {
                if (err instanceof Error) {
                    setError(err.message);
                } else {
                    setError('error inespeardo');
                }
            } finally {
                setLoading(false);
            }
        };
        fetchData();
    }, [currentPage]);

    const handleViewDetails = async (id: number) => {
        try {
            const response = await fetch(`http://127.0.0.1:8001/futbolistas/${id}`);
            if (!response.ok) {
                throw new Error('error en llamado de api');
            }
            const futbolista: Futbolista = await response.json();
            alert(`Detalles del Futbolista:\n\nID: ${futbolista.id}\nNombres: ${futbolista.nombres}\nApellidos: ${futbolista.apellidos}\nFecha Nacimiento: ${futbolista.fecha_nacimiento}\nCaracterísticas: ${futbolista.caracteristicas}\nPosición: ${futbolista.posicion.nombre}`);
        } catch (err) {
            if (err instanceof Error) {
                setError(err.message);
            } else {
                setError('error inesperado');
            }
        }
    };

    const nextPage = () => {
        setCurrentPage(prevPage => prevPage + 1);
    };

    const prevPage = () => {
        if (currentPage > 0) {
            setCurrentPage(prevPage => prevPage - 1);
        }
    };

    if (loading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error: {error}</div>;
    }

    return (
        <div>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombres</th>
                        <th>Apellidos</th>
                        <th>Posición</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    {futbolistas.map(futbolista => (
                        <tr key={futbolista.id}>
                            <td>{futbolista.id}</td>
                            <td>{futbolista.nombres}</td>
                            <td>{futbolista.apellidos}</td>
                            <td>{futbolista.posicion.nombre}</td>
                            <td>
                                <button onClick={() => handleViewDetails(futbolista.id)}>Ver Detalles</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <div>
                <button onClick={prevPage} disabled={currentPage === 0}>Anterior</button>
                <button onClick={nextPage} disabled={currentPage === totalPages - 1}>Siguiente</button>
            </div>
        </div>
    );
};

export default FutbolistasTable;
