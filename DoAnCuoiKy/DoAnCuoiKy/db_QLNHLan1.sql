create database dbQLNH
go
USE [dbQLNH]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 04/04/2023 13:11:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[UserName] [nvarchar](100) NOT NULL,
	[DisplayName] [nvarchar](100) NULL,
	[PassWord] [nvarchar](1000) NULL,
	[Type] [int] NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[UserName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[banAn]    Script Date: 04/04/2023 13:11:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[banAn](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ten_Ban] [nvarchar](50) NULL,
	[trang_Thai] [nvarchar](50) NULL,
 CONSTRAINT [PK_banAn] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ctHoaDon]    Script Date: 04/04/2023 13:11:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ctHoaDon](
	[idHD] [int] NOT NULL,
	[idMon] [int] NOT NULL,
	[soLuong] [int] NULL,
	[donGia] [float] NULL,
 CONSTRAINT [PK_ctHoaDon] PRIMARY KEY CLUSTERED 
(
	[idHD] ASC,
	[idMon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[datBan]    Script Date: 04/04/2023 13:11:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[datBan](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[tenKH] [nvarchar](50) NULL,
	[sdt] [nvarchar](50) NULL,
	[idBan] [int] NULL,
 CONSTRAINT [PK_datBan] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[datPhong]    Script Date: 04/04/2023 13:11:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[datPhong](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[tenKH] [nvarchar](50) NULL,
	[sdt] [nvarchar](50) NULL,
	[idPhong] [int] NULL,
 CONSTRAINT [PK_datPhong] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[hoaDon]    Script Date: 04/04/2023 13:11:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[hoaDon](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[idBan] [int] NULL,
	[ngayTao] [datetime] NULL,
	[tongTien] [float] NULL,
	[idPhong] [int] NULL,
 CONSTRAINT [PK_hoaDon] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[kiemTraTon]    Script Date: 04/04/2023 13:11:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[kiemTraTon](
	[id] [int] NOT NULL,
	[soLuong] [int] NULL,
 CONSTRAINT [PK_kiemTraTon] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[loaiMonAn]    Script Date: 04/04/2023 13:11:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[loaiMonAn](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[tenLoai] [nvarchar](50) NULL,
 CONSTRAINT [PK_loaiMonAn] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[monAn]    Script Date: 04/04/2023 13:11:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[monAn](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[tenMon] [nvarchar](50) NULL,
	[gia] [float] NULL,
	[idLoai] [int] NULL,
 CONSTRAINT [PK_monAn] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[nhapKho]    Script Date: 04/04/2023 13:11:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[nhapKho](
	[id] [int] NOT NULL,
	[tenNguyenLieu] [nvarchar](50) NULL,
	[soLuong] [int] NULL,
	[donGia] [float] NULL,
 CONSTRAINT [PK_nhapKho] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PhongAn]    Script Date: 04/04/2023 13:11:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhongAn](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[tenPhong] [nvarchar](50) NULL,
	[trangThai] [nvarchar](50) NULL,
 CONSTRAINT [PK_PhongAn] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[xuatKho]    Script Date: 04/04/2023 13:11:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[xuatKho](
	[id] [int] NOT NULL,
	[tenNguyenLieu] [nvarchar](50) NULL,
	[soLuongTon] [int] NULL,
 CONSTRAINT [PK_xuatKho] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[Account] ([UserName], [DisplayName], [PassWord], [Type]) VALUES (N'Ad', N'Admin', N'1', 1)
INSERT [dbo].[Account] ([UserName], [DisplayName], [PassWord], [Type]) VALUES (N'nv1', N'Nhân viên 01', N'1', 0)
SET IDENTITY_INSERT [dbo].[banAn] ON 

INSERT [dbo].[banAn] ([id], [ten_Ban], [trang_Thai]) VALUES (1, N'Bàn 01', N'Đã Đặt')
INSERT [dbo].[banAn] ([id], [ten_Ban], [trang_Thai]) VALUES (2, N'Bàn 02', N'Trống')
INSERT [dbo].[banAn] ([id], [ten_Ban], [trang_Thai]) VALUES (3, N'Bàn 03', N'Đã Đặt')
INSERT [dbo].[banAn] ([id], [ten_Ban], [trang_Thai]) VALUES (4, N'Bàn 04', N'Trống')
INSERT [dbo].[banAn] ([id], [ten_Ban], [trang_Thai]) VALUES (5, N'Bàn 05', N'Trống')
INSERT [dbo].[banAn] ([id], [ten_Ban], [trang_Thai]) VALUES (6, N'Bàn 06', N'Trống')
INSERT [dbo].[banAn] ([id], [ten_Ban], [trang_Thai]) VALUES (7, N'Bàn 07', N'Trống')
INSERT [dbo].[banAn] ([id], [ten_Ban], [trang_Thai]) VALUES (8, N'Bàn 08', N'Trống')
SET IDENTITY_INSERT [dbo].[banAn] OFF
SET IDENTITY_INSERT [dbo].[datBan] ON 

INSERT [dbo].[datBan] ([id], [tenKH], [sdt], [idBan]) VALUES (6, N'Nguyễn Tiến', N'012222', 3)
INSERT [dbo].[datBan] ([id], [tenKH], [sdt], [idBan]) VALUES (7, N'Nguyễn Tiến', N'012222', 3)
INSERT [dbo].[datBan] ([id], [tenKH], [sdt], [idBan]) VALUES (8, N' Hữu', N'21321315', 3)
INSERT [dbo].[datBan] ([id], [tenKH], [sdt], [idBan]) VALUES (9, N' Hữu Khùng', N'321651561', 1)
SET IDENTITY_INSERT [dbo].[datBan] OFF
SET IDENTITY_INSERT [dbo].[datPhong] ON 

INSERT [dbo].[datPhong] ([id], [tenKH], [sdt], [idPhong]) VALUES (2, N'Huu', N'11512', 2)
SET IDENTITY_INSERT [dbo].[datPhong] OFF
SET IDENTITY_INSERT [dbo].[loaiMonAn] ON 

INSERT [dbo].[loaiMonAn] ([id], [tenLoai]) VALUES (1, N'Nước')
INSERT [dbo].[loaiMonAn] ([id], [tenLoai]) VALUES (2, N'Bia, rượu')
INSERT [dbo].[loaiMonAn] ([id], [tenLoai]) VALUES (3, N'Đồ nhắm')
INSERT [dbo].[loaiMonAn] ([id], [tenLoai]) VALUES (4, N'Tráng miệng')
INSERT [dbo].[loaiMonAn] ([id], [tenLoai]) VALUES (5, N'Khai vị')
INSERT [dbo].[loaiMonAn] ([id], [tenLoai]) VALUES (6, N'Hải sản')
INSERT [dbo].[loaiMonAn] ([id], [tenLoai]) VALUES (7, N'Cơm')
SET IDENTITY_INSERT [dbo].[loaiMonAn] OFF
SET IDENTITY_INSERT [dbo].[monAn] ON 

INSERT [dbo].[monAn] ([id], [tenMon], [gia], [idLoai]) VALUES (1, N'Bia tiger', 80000, 2)
INSERT [dbo].[monAn] ([id], [tenMon], [gia], [idLoai]) VALUES (2, N'Bia strong bow', 21000, 2)
INSERT [dbo].[monAn] ([id], [tenMon], [gia], [idLoai]) VALUES (3, N'Nước suối', 10000, 1)
INSERT [dbo].[monAn] ([id], [tenMon], [gia], [idLoai]) VALUES (4, N'Sting', 10000, 1)
INSERT [dbo].[monAn] ([id], [tenMon], [gia], [idLoai]) VALUES (5, N'Mực nướng', 120000, 3)
INSERT [dbo].[monAn] ([id], [tenMon], [gia], [idLoai]) VALUES (6, N'Khô gà', 50000, 3)
INSERT [dbo].[monAn] ([id], [tenMon], [gia], [idLoai]) VALUES (7, N'Chân gà sốt thái', 120000, 3)
SET IDENTITY_INSERT [dbo].[monAn] OFF
SET IDENTITY_INSERT [dbo].[PhongAn] ON 

INSERT [dbo].[PhongAn] ([id], [tenPhong], [trangThai]) VALUES (1, N'Phòng VIP 01', N'Đã Đặt')
INSERT [dbo].[PhongAn] ([id], [tenPhong], [trangThai]) VALUES (2, N'Phòng VIP 02', N'Đã Đặt')
INSERT [dbo].[PhongAn] ([id], [tenPhong], [trangThai]) VALUES (3, N'Phòng VIP 03', N'Trống')
INSERT [dbo].[PhongAn] ([id], [tenPhong], [trangThai]) VALUES (4, N'Phòng VIP 04', N'Trống')
SET IDENTITY_INSERT [dbo].[PhongAn] OFF
ALTER TABLE [dbo].[ctHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ctHoaDon_hoaDon] FOREIGN KEY([idHD])
REFERENCES [dbo].[hoaDon] ([id])
GO
ALTER TABLE [dbo].[ctHoaDon] CHECK CONSTRAINT [FK_ctHoaDon_hoaDon]
GO
ALTER TABLE [dbo].[ctHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ctHoaDon_monAn] FOREIGN KEY([idMon])
REFERENCES [dbo].[monAn] ([id])
GO
ALTER TABLE [dbo].[ctHoaDon] CHECK CONSTRAINT [FK_ctHoaDon_monAn]
GO
ALTER TABLE [dbo].[datBan]  WITH CHECK ADD  CONSTRAINT [FK_datBan_banAn] FOREIGN KEY([idBan])
REFERENCES [dbo].[banAn] ([id])
GO
ALTER TABLE [dbo].[datBan] CHECK CONSTRAINT [FK_datBan_banAn]
GO
ALTER TABLE [dbo].[datPhong]  WITH CHECK ADD  CONSTRAINT [FK_datPhong_PhongAn] FOREIGN KEY([idPhong])
REFERENCES [dbo].[PhongAn] ([id])
GO
ALTER TABLE [dbo].[datPhong] CHECK CONSTRAINT [FK_datPhong_PhongAn]
GO
ALTER TABLE [dbo].[hoaDon]  WITH CHECK ADD  CONSTRAINT [FK_hoaDon_banAn] FOREIGN KEY([idBan])
REFERENCES [dbo].[banAn] ([id])
GO
ALTER TABLE [dbo].[hoaDon] CHECK CONSTRAINT [FK_hoaDon_banAn]
GO
ALTER TABLE [dbo].[hoaDon]  WITH CHECK ADD  CONSTRAINT [FK_hoaDon_PhongAn] FOREIGN KEY([idPhong])
REFERENCES [dbo].[PhongAn] ([id])
GO
ALTER TABLE [dbo].[hoaDon] CHECK CONSTRAINT [FK_hoaDon_PhongAn]
GO
ALTER TABLE [dbo].[kiemTraTon]  WITH CHECK ADD  CONSTRAINT [FK_kiemTraTon_nhapKho] FOREIGN KEY([id])
REFERENCES [dbo].[nhapKho] ([id])
GO
ALTER TABLE [dbo].[kiemTraTon] CHECK CONSTRAINT [FK_kiemTraTon_nhapKho]
GO
ALTER TABLE [dbo].[monAn]  WITH CHECK ADD  CONSTRAINT [FK_monAn_loaiMonAn] FOREIGN KEY([idLoai])
REFERENCES [dbo].[loaiMonAn] ([id])
GO
ALTER TABLE [dbo].[monAn] CHECK CONSTRAINT [FK_monAn_loaiMonAn]
GO
ALTER TABLE [dbo].[xuatKho]  WITH CHECK ADD  CONSTRAINT [FK_xuatKho_nhapKho] FOREIGN KEY([id])
REFERENCES [dbo].[nhapKho] ([id])
GO
ALTER TABLE [dbo].[xuatKho] CHECK CONSTRAINT [FK_xuatKho_nhapKho]
GO
/****** Object:  Trigger [dbo].[update_table_status]    Script Date: 04/04/2023 13:11:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TRIGGER [dbo].[update_table_status]
ON [dbo].[datBan]
FOR INSERT,UPDATE
AS
BEGIN
    UPDATE banAn
    SET trang_Thai = N'Đã Đặt'
    WHERE id IN (
        SELECT idBan
        FROM inserted
    )
END
GO
/****** Object:  Trigger [dbo].[update_room_status]    Script Date: 04/04/2023 13:11:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TRIGGER [dbo].[update_room_status]
ON [dbo].[datPhong]
FOR INSERT,UPDATE
AS
BEGIN
    UPDATE PhongAn
    SET trangThai = N'Đã Đặt'
    WHERE id IN (
        SELECT idPhong
        FROM inserted
    )
END
GO
insert into nhapKho
values
(1,N'Gà',4,4000),
(2,N'Bò',2,9000),
(3,N'Vịt',3,2000),
(4,N'Nấm',1,100)

insert into xuatKho
values
(1,N'Gà chiên Xù',4),
(2,N'Bò tái chanh',2),
(3,N'Vịt hầm thuốc bắc ',3),
(4,N'Nấm mèo xào mỡ',1)

select *
from nhapKho

select *
from xuatKho

select *
from kiemTraTon