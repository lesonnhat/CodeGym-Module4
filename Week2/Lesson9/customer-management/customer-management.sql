Create database testdb;

-- Chèn dữ liệu vào bảng Provinces
INSERT INTO Provinces (name) VALUES
('Hà Nội'),
('Hồ Chí Minh'),
('Đà Nẵng');

-- Chèn dữ liệu vào bảng Customers
INSERT INTO Customers (name, email, address, province_id) VALUES
('Nguyễn Văn An', 'an.nguyen@example.com', '123 Đường Láng, Hà Nội', 1),
('Trần Thị Bình', 'binh.tran@example.com', '456 Nguyễn Huệ, Hồ Chí Minh', 2),
('Lê Văn Cường', 'cuong.le@example.com', '789 Bạch Đằng, Đà Nẵng', 3);