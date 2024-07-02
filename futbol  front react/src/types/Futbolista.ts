// src/types/Futbolista.ts
export interface Posicion {
    id: number;
    nombre: string;
}

export interface Futbolista {
    id: number;
    nombres: string;
    apellidos: string;
    fecha_nacimiento: string;
    caracteristicas: string;
    posicion: Posicion;
}
