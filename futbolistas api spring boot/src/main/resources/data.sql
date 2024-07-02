-- Insert positions
INSERT INTO posicion (nombre) VALUES ('arquero');
INSERT INTO posicion (nombre) VALUES ('defensa');
INSERT INTO posicion (nombre) VALUES ('mediocampista');

-- Insert futbolistas
INSERT INTO futbolista (nombres, apellidos, fecha_nacimiento, caracteristicas, id_posicion)
VALUES ('Juan', 'Perez', '1990-05-10', 'Rápido y ágil', (SELECT id FROM posicion WHERE nombre = 'arquero'));

INSERT INTO futbolista (nombres, apellidos, fecha_nacimiento, caracteristicas, id_posicion)
VALUES ('Carlos', 'Gomez', '1985-08-20', 'Defensa fuerte', (SELECT id FROM posicion WHERE nombre = 'defensa'));

INSERT INTO futbolista (nombres, apellidos, fecha_nacimiento, caracteristicas, id_posicion)
VALUES ('Luis', 'Lopez', '1992-01-15', 'Buen manejo del balón', (SELECT id FROM posicion WHERE nombre = 'mediocampista'));
