
-- Usar la base de datos
USE rincon_perfumes_back;

-- ============================================
-- 1. ROLES
-- ============================================
INSERT INTO rol (nombre_rol, descripcion_rol) VALUES 
('CLIENTE', 'Cliente del sistema'),
('ENCARGADO', 'Encargado de productos'),
('ADMIN_MAESTRO', 'Administrador maestro')
ON DUPLICATE KEY UPDATE descripcion_rol=VALUES(descripcion_rol);

-- ============================================
-- 2. USUARIO ADMIN INICIAL
-- ============================================
INSERT INTO usuario (nombre, apellido, correo, contrasena, activo) 
VALUES ('Admin', 'Sistema', 'admin@test.cl', 'admin123', true)
ON DUPLICATE KEY UPDATE activo=true;

-- ============================================
-- 3. ASIGNAR ROL ADMIN
-- ============================================
-- Nota: Ajustar IDs si es necesario
INSERT IGNORE INTO usuario_rol (id_usuario, id_rol)
SELECT 
    (SELECT id_usuario FROM usuario WHERE correo = 'admin@test.cl'),
    (SELECT id_rol FROM rol WHERE nombre_rol = 'ADMIN_MAESTRO');

-- ============================================
-- 4. TIPOS DE PRODUCTO
-- ============================================
INSERT INTO tipo_producto (nombre_tipo) VALUES 
('EDP'),
('EDT'),
('EDC'),
('PARFUM')
ON DUPLICATE KEY UPDATE nombre_tipo=VALUES(nombre_tipo);

-- ============================================
-- 5. GÉNEROS
-- ============================================
INSERT INTO genero (nombre_genero) VALUES 
('HOMBRE'),
('MUJER'),
('UNISEX')
ON DUPLICATE KEY UPDATE nombre_genero=VALUES(nombre_genero);

-- ============================================
-- 6. CATEGORÍAS DE MARCA
-- ============================================
INSERT INTO categoria (nombre_categoria, descripcion) VALUES 
('ARABES', 'Perfumes árabes'),
('EXCLUSIVAS', 'Marcas exclusivas y de nicho'),
('DISEÑADOR', 'Marcas de diseñador reconocidas')
ON DUPLICATE KEY UPDATE descripcion=VALUES(descripcion);

-- ============================================
-- 7. MARCAS
-- ============================================
INSERT INTO marca (nombre_marca, id_categoria) VALUES 
('Dior', (SELECT id_categoria FROM categoria WHERE nombre_categoria = 'DISEÑADOR')),
('Chanel', (SELECT id_categoria FROM categoria WHERE nombre_categoria = 'DISEÑADOR')),
('Lattafa', (SELECT id_categoria FROM categoria WHERE nombre_categoria = 'ARABES')),
('Creed', (SELECT id_categoria FROM categoria WHERE nombre_categoria = 'EXCLUSIVAS')),
('Tom Ford', (SELECT id_categoria FROM categoria WHERE nombre_categoria = 'DISEÑADOR')),
('Armaf', (SELECT id_categoria FROM categoria WHERE nombre_categoria = 'ARABES'))
ON DUPLICATE KEY UPDATE nombre_marca=VALUES(nombre_marca);

-- ============================================
-- 8. PRODUCTOS DE EJEMPLO (OPCIONAL)
-- ============================================
-- Puedes descomentar esto para tener productos de prueba

/*
INSERT INTO producto (nombre_producto, descripcion, precio, volumen_ml, id_marca, id_categoria, id_tipo_producto, id_genero, stock, activo, aroma, familia_olfativa) VALUES
('Dior Sauvage', 'Fragancia fresca y especiada', 89990, 100, 
 (SELECT id_marca FROM marca WHERE nombre_marca = 'Dior'),
 (SELECT id_categoria FROM categoria WHERE nombre_categoria = 'DISEÑADOR'),
 (SELECT id_tipo_producto FROM tipo_producto WHERE nombre_tipo = 'EDP'),
 (SELECT id_genero FROM genero WHERE nombre_genero = 'HOMBRE'),
 50, true, 'Fresco Especiado', 'Aromática'),
 
('Chanel No 5', 'Icónico perfume femenino', 125990, 100,
 (SELECT id_marca FROM marca WHERE nombre_marca = 'Chanel'),
 (SELECT id_categoria FROM categoria WHERE nombre_categoria = 'DISEÑADOR'),
 (SELECT id_tipo_producto FROM tipo_producto WHERE nombre_tipo = 'PARFUM'),
 (SELECT id_genero FROM genero WHERE nombre_genero = 'MUJER'),
 30, true, 'Floral Aldehídico', 'Floral');
*/

-- ============================================
-- 9. PROMOCIÓN DE EJEMPLO
-- ============================================
INSERT INTO promociones (nombre, descripcion, porcentaje_descuento, monto_minimo, fecha_inicio, fecha_fin, activo) VALUES
('Descuento por compra mayor', 'Descuento del 10% en compras superiores a $59.990', 10.00, 59990.00, '2025-01-01', '2025-12-31', true)
ON DUPLICATE KEY UPDATE activo=true;

-- ============================================
-- FIN DEL SCRIPT
-- ============================================
-- Para verificar que todo se insertó correctamente:
SELECT 'Roles:', COUNT(*) FROM rol;
SELECT 'Usuarios:', COUNT(*) FROM usuario;
SELECT 'Tipos de Producto:', COUNT(*) FROM tipo_producto;
SELECT 'Géneros:', COUNT(*) FROM genero;
SELECT 'Categorías:', COUNT(*) FROM categoria;
SELECT 'Marcas:', COUNT(*) FROM marca;
SELECT 'Promociones:', COUNT(*) FROM promociones;
