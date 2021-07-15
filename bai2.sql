use master 
go
create database QLBH
go
use QLBH
go
create table NhanVien(
MaNV int identity(1,1) primary key,
TenNhanVien nvarchar(50),
NgaySinh DateTime,
DiaChi nvarchar(50),
SoDienThoai varchar(12),
GioiTinh nvarchar(10)
)
go
create table SanPham(
MaSP int identity(1,1) primary key,
TenSP nvarchar(50),
DonViTinh nvarchar (50),
Gia money
)
go
create table HoaDon(
MaHD int identity(1,1) primary key,
MaNV int,
LoaiHD nvarchar(20),
NgayLap Datetime,
NgayGiaoNhan Datetime,
DienGiai nvarchar(60),
constraint fk_nv foreign key (MaNV ) references NhanVien(MaNV)
)
create table ChiTietHoaDon(
MaHD int,
MaSP int,
SoLuong int,
constraint pk primary key (MaHD, MaSP),
constraint fkhd foreign key (MaHD ) references HoaDon(MaHD),
constraint fksp foreign key (MaSP ) references SanPham(MaSP)
)
go
insert into NhanVien values (N'Đỗ Vinh Hà',N'2000-01-14',N'Hà Nội','0982172855','Nam'), 
											(N'Nguyễn Đức Điệp',N'2000-07-17',N'Hà Nội','0982172866','Nam'),
											(N'Đoàn Duy Nam',N'2021-02-15',N'Hải Phòng','0982172877',N'Nữ')
go
insert into SanPham values(N'Điện thoại SS S10',N'Chiếc',20000000),(N'Điện thoại Oppo A37',N'Chiếc',4000000)
go
insert into HoaDon values (1,N'Xuất','2021-01-10','2021-01-17',N'Giao hàng tận nơi, thu phí shipcod'),
											(2,N'Nhập','2021-01-11','2021-01-16',N'Giao hàng tận nơi, thu phí shipcod')
go
insert into ChiTietHoaDon values (2,1,10),(2,2,5), (3,1,100), (3,2,100)
go
select * from NhanVien
select * from SanPham
select * from HoaDon
select * from ChiTietHoaDon
