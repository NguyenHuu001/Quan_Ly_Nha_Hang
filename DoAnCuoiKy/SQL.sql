USE [dbQLNH]
GO
/****** Object:  StoredProcedure [dbo].[USP_getIDFood]    Script Date: 4/21/2023 11:08:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[USP_getIDFood](@nameFood nvarchar(50), @idFood int OUTPUT)
AS
BEGIN
    SELECT @idFood = id FROM monAn WHERE tenMon LIKE @nameFood;
END

GO
/****** Object:  StoredProcedure [dbo].[USP_InsertBillRoom]    Script Date: 4/21/2023 11:08:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[USP_InsertBillRoom]
@idRoom INT
AS
BEGIN
	INSERT dbo.hoaDon 
	        ( idPhong,
			tongTien,
			ngayTao,idBan,status
	        )
	VALUES  ( 
	          @idRoom ,
			  0,
			  GETDATE(),null,0
	          
	        )
END

GO
/****** Object:  StoredProcedure [dbo].[USP_InsertBillTable]    Script Date: 4/21/2023 11:08:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[USP_InsertBillTable]
@idTable INT
AS
BEGIN
	INSERT dbo.hoaDon 
	        ( idBan,
			tongTien,
			ngayTao,idPhong,status
	        )
	VALUES  ( 
	          @idTable ,
			  0,
			  GETDATE()
	          ,null,0
	        )
END

GO
/****** Object:  StoredProcedure [dbo].[USP_InsertCTHoaDon]    Script Date: 4/21/2023 11:08:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[USP_InsertCTHoaDon]
@idBill INT, @nameFood nvarchar(50), @count INT
AS
BEGIN

	DECLARE @isExitsBillInfo INT
	DECLARE @foodCount INT = 1
	DECLARE @idFood int
	EXEC USP_getIDFood @nameFood, @idFood OUTPUT;
	
	SELECT @isExitsBillInfo =b.id, @foodCount = b.soLuong 
	FROM ctHoaDon AS b 
	WHERE idHD = @idBill AND idMon = @idFood

	IF (@isExitsBillInfo > 0)
	BEGIN
		DECLARE @newCount INT = @foodCount + @count
		IF (@newCount > 0)
			UPDATE dbo.ctHoaDon	SET soLuong = @foodCount + @count WHERE idMon = @idFood and idHD = @idBill
		ELSE
			DELETE dbo.ctHoaDon WHERE idHD = @idBill AND idMon = @idFood
	END
	ELSE
	BEGIN
		INSERT	dbo.ctHoaDon
        ( idHD, idMon, soLuong )
		VALUES  ( @idBill, -- idBill - int
          @idFood, -- idFood - int
          @count  -- count - int
          )
	END
END

GO
/****** Object:  StoredProcedure [dbo].[USP_ShowBillRoom]    Script Date: 4/21/2023 11:08:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[USP_ShowBillRoom]
@idRom int
as
begin
	SELECT f.tenMon, bi.soLuong, f.gia, f.gia*bi.soLuong AS totalPrice FROM ctHoaDon AS bi, hoaDon AS b, monAn AS f WHERE bi.idHD = b.id AND bi.idMon = f.id AND b.idPhong = @idRom and b.status=0
end

GO
/****** Object:  StoredProcedure [dbo].[USP_ShowBillTable]    Script Date: 4/21/2023 11:08:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[USP_ShowBillTable]
@idBan int
as
begin
	SELECT f.tenMon, bi.soLuong, f.gia, f.gia*bi.soLuong AS totalPrice FROM ctHoaDon AS bi, hoaDon AS b, monAn AS f WHERE bi.idHD = b.id AND bi.idMon = f.id AND b.idBan = @idBan and b.status=0
end

GO
/****** Object:  Table [dbo].[Account]    Script Date: 4/21/2023 11:08:11 AM ******/
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
/****** Object:  Table [dbo].[banAn]    Script Date: 4/21/2023 11:08:11 AM ******/
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
/****** Object:  Table [dbo].[ctHoaDon]    Script Date: 4/21/2023 11:08:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ctHoaDon](
	[idHD] [int] NOT NULL,
	[idMon] [int] NOT NULL,
	[soLuong] [int] NULL,
	[donGia] [float] NULL,
	[id] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_ctHoaDon] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[datBan]    Script Date: 4/21/2023 11:08:11 AM ******/
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
/****** Object:  Table [dbo].[datPhong]    Script Date: 4/21/2023 11:08:11 AM ******/
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
/****** Object:  Table [dbo].[hoaDon]    Script Date: 4/21/2023 11:08:11 AM ******/
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
	[status] [int] NULL,
 CONSTRAINT [PK_hoaDon] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[kiemTraTon]    Script Date: 4/21/2023 11:08:11 AM ******/
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
/****** Object:  Table [dbo].[loaiMonAn]    Script Date: 4/21/2023 11:08:11 AM ******/
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
/****** Object:  Table [dbo].[monAn]    Script Date: 4/21/2023 11:08:11 AM ******/
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
/****** Object:  Table [dbo].[nhapKho]    Script Date: 4/21/2023 11:08:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[nhapKho](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[tenNguyenLieu] [nvarchar](50) NULL,
	[ngayNhap] [nvarchar](50) NULL,
	[soLuong] [int] NULL,
	[donGia] [float] NULL,
 CONSTRAINT [PK_nhapKho] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PhongAn]    Script Date: 4/21/2023 11:08:11 AM ******/
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
/****** Object:  Table [dbo].[xuatKho]    Script Date: 4/21/2023 11:08:11 AM ******/
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
INSERT [dbo].[banAn] ([id], [ten_Ban], [trang_Thai]) VALUES (3, N'Bàn 03', N'Có người')
INSERT [dbo].[banAn] ([id], [ten_Ban], [trang_Thai]) VALUES (4, N'Bàn 04', N'Trống')
INSERT [dbo].[banAn] ([id], [ten_Ban], [trang_Thai]) VALUES (5, N'Bàn 05', N'Trống')
INSERT [dbo].[banAn] ([id], [ten_Ban], [trang_Thai]) VALUES (6, N'Bàn 06', N'Trống')
INSERT [dbo].[banAn] ([id], [ten_Ban], [trang_Thai]) VALUES (7, N'Bàn 07', N'Trống')
INSERT [dbo].[banAn] ([id], [ten_Ban], [trang_Thai]) VALUES (8, N'Bàn 08', N'Đã Đặt')
SET IDENTITY_INSERT [dbo].[banAn] OFF
SET IDENTITY_INSERT [dbo].[ctHoaDon] ON 

INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (62, 3, 2, NULL, 1176)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (63, 1, 5, NULL, 1177)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (63, 2, 3, NULL, 1178)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (63, 3, 9, NULL, 1179)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (64, 4, 12, NULL, 1180)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (66, 1, 5, NULL, 1181)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (66, 2, 5, NULL, 1182)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (66, 5, 3, NULL, 1183)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (67, 3, 10, NULL, 1184)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (67, 4, 2, NULL, 1185)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (68, 3, 2, NULL, 1186)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (69, 3, 14, NULL, 1187)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (70, 4, 2, NULL, 1188)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (71, 4, 4, NULL, 1189)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (72, 5, 3, NULL, 1190)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (71, 1, 6, NULL, 1191)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (73, 1, 2, NULL, 1192)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (71, 3, 16, NULL, 1193)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (74, 3, 5, NULL, 1194)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (72, 3, 7, NULL, 1195)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (75, 3, 5, NULL, 1196)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (76, 3, 3, NULL, 1197)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (72, 1, 9, NULL, 1198)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (77, 1, 4, NULL, 1199)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (78, 3, 3, NULL, 1200)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (79, 1, 5, NULL, 1201)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (71, 5, 10, NULL, 1202)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (80, 5, 3, NULL, 1203)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (72, 7, 2, NULL, 1204)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (81, 7, 2, NULL, 1205)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (82, 3, 3, NULL, 1206)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (83, 4, 1, NULL, 1207)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (84, 3, 5, NULL, 1208)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (83, 5, 5, NULL, 1209)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (85, 3, 2, NULL, 1210)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (86, 3, 3, NULL, 1211)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (87, 3, 3, NULL, 1212)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (88, 3, 4, NULL, 1213)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (88, 4, 3, NULL, 1226)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (88, 6, 3, NULL, 1228)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (82, 2, 2, NULL, 1296)
INSERT [dbo].[ctHoaDon] ([idHD], [idMon], [soLuong], [donGia], [id]) VALUES (84, 2, 3, NULL, 1297)
SET IDENTITY_INSERT [dbo].[ctHoaDon] OFF
SET IDENTITY_INSERT [dbo].[datBan] ON 

INSERT [dbo].[datBan] ([id], [tenKH], [sdt], [idBan]) VALUES (12, N'Tien', N'098843322', 8)
SET IDENTITY_INSERT [dbo].[datBan] OFF
SET IDENTITY_INSERT [dbo].[datPhong] ON 

INSERT [dbo].[datPhong] ([id], [tenKH], [sdt], [idPhong]) VALUES (2, N'Huu', N'11512', 2)
SET IDENTITY_INSERT [dbo].[datPhong] OFF
SET IDENTITY_INSERT [dbo].[hoaDon] ON 

INSERT [dbo].[hoaDon] ([id], [idBan], [ngayTao], [tongTien], [idPhong], [status]) VALUES (62, 1, CAST(N'2023-04-09 22:43:51.080' AS DateTime), 20000, NULL, 1)
INSERT [dbo].[hoaDon] ([id], [idBan], [ngayTao], [tongTien], [idPhong], [status]) VALUES (63, 2, CAST(N'2023-04-09 22:44:01.120' AS DateTime), 240000, NULL, 1)
INSERT [dbo].[hoaDon] ([id], [idBan], [ngayTao], [tongTien], [idPhong], [status]) VALUES (64, 1, CAST(N'2023-04-09 22:47:18.120' AS DateTime), 120000, NULL, 1)
INSERT [dbo].[hoaDon] ([id], [idBan], [ngayTao], [tongTien], [idPhong], [status]) VALUES (66, 1, CAST(N'2023-04-09 23:01:13.537' AS DateTime), 865000, NULL, 1)
INSERT [dbo].[hoaDon] ([id], [idBan], [ngayTao], [tongTien], [idPhong], [status]) VALUES (67, NULL, CAST(N'2023-04-11 07:45:33.033' AS DateTime), 0, 1, 0)
INSERT [dbo].[hoaDon] ([id], [idBan], [ngayTao], [tongTien], [idPhong], [status]) VALUES (68, 1, CAST(N'2023-04-19 14:07:33.677' AS DateTime), 0, NULL, 0)
INSERT [dbo].[hoaDon] ([id], [idBan], [ngayTao], [tongTien], [idPhong], [status]) VALUES (69, 3, CAST(N'2023-04-19 14:11:05.003' AS DateTime), 20000, NULL, 1)
INSERT [dbo].[hoaDon] ([id], [idBan], [ngayTao], [tongTien], [idPhong], [status]) VALUES (70, 3, CAST(N'2023-04-19 14:21:33.840' AS DateTime), 20000, NULL, 1)
INSERT [dbo].[hoaDon] ([id], [idBan], [ngayTao], [tongTien], [idPhong], [status]) VALUES (71, 4, CAST(N'2023-04-19 14:23:31.650' AS DateTime), 10000, NULL, 1)
INSERT [dbo].[hoaDon] ([id], [idBan], [ngayTao], [tongTien], [idPhong], [status]) VALUES (72, NULL, CAST(N'2023-04-19 14:27:04.353' AS DateTime), 50000, 2, 1)
INSERT [dbo].[hoaDon] ([id], [idBan], [ngayTao], [tongTien], [idPhong], [status]) VALUES (73, 3, CAST(N'2023-04-19 14:33:03.733' AS DateTime), 160000, NULL, 1)
INSERT [dbo].[hoaDon] ([id], [idBan], [ngayTao], [tongTien], [idPhong], [status]) VALUES (74, 4, CAST(N'2023-04-19 14:41:04.240' AS DateTime), 50000, NULL, 1)
INSERT [dbo].[hoaDon] ([id], [idBan], [ngayTao], [tongTien], [idPhong], [status]) VALUES (75, NULL, CAST(N'2023-04-19 14:46:15.947' AS DateTime), 50000, 2, 1)
INSERT [dbo].[hoaDon] ([id], [idBan], [ngayTao], [tongTien], [idPhong], [status]) VALUES (76, 3, CAST(N'2023-04-19 14:47:39.740' AS DateTime), 320000, NULL, 1)
INSERT [dbo].[hoaDon] ([id], [idBan], [ngayTao], [tongTien], [idPhong], [status]) VALUES (77, NULL, CAST(N'2023-04-19 14:48:02.620' AS DateTime), 320000, 2, 1)
INSERT [dbo].[hoaDon] ([id], [idBan], [ngayTao], [tongTien], [idPhong], [status]) VALUES (78, 3, CAST(N'2023-04-19 14:48:49.197' AS DateTime), 400000, NULL, 1)
INSERT [dbo].[hoaDon] ([id], [idBan], [ngayTao], [tongTien], [idPhong], [status]) VALUES (79, NULL, CAST(N'2023-04-19 14:49:03.150' AS DateTime), 400000, 2, 1)
INSERT [dbo].[hoaDon] ([id], [idBan], [ngayTao], [tongTien], [idPhong], [status]) VALUES (80, 3, CAST(N'2023-04-19 14:56:54.210' AS DateTime), 360000, NULL, 1)
INSERT [dbo].[hoaDon] ([id], [idBan], [ngayTao], [tongTien], [idPhong], [status]) VALUES (81, NULL, CAST(N'2023-04-19 14:57:24.950' AS DateTime), 240000, 2, 1)
INSERT [dbo].[hoaDon] ([id], [idBan], [ngayTao], [tongTien], [idPhong], [status]) VALUES (82, 2, CAST(N'2023-04-19 14:58:10.467' AS DateTime), 72000, NULL, 1)
INSERT [dbo].[hoaDon] ([id], [idBan], [ngayTao], [tongTien], [idPhong], [status]) VALUES (83, 3, CAST(N'2023-04-19 14:59:22.483' AS DateTime), 0, NULL, 0)
INSERT [dbo].[hoaDon] ([id], [idBan], [ngayTao], [tongTien], [idPhong], [status]) VALUES (84, NULL, CAST(N'2023-04-19 14:59:44.163' AS DateTime), 72000, 2, 1)
INSERT [dbo].[hoaDon] ([id], [idBan], [ngayTao], [tongTien], [idPhong], [status]) VALUES (85, 4, CAST(N'2023-04-19 15:03:14.323' AS DateTime), 20000, NULL, 1)
INSERT [dbo].[hoaDon] ([id], [idBan], [ngayTao], [tongTien], [idPhong], [status]) VALUES (86, 4, CAST(N'2023-04-19 15:04:37.600' AS DateTime), 30000, NULL, 1)
INSERT [dbo].[hoaDon] ([id], [idBan], [ngayTao], [tongTien], [idPhong], [status]) VALUES (87, 4, CAST(N'2023-04-19 15:06:10.097' AS DateTime), 30000, NULL, 1)
INSERT [dbo].[hoaDon] ([id], [idBan], [ngayTao], [tongTien], [idPhong], [status]) VALUES (88, 4, CAST(N'2023-04-19 15:08:46.103' AS DateTime), 220000, NULL, 1)
SET IDENTITY_INSERT [dbo].[hoaDon] OFF
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
SET IDENTITY_INSERT [dbo].[nhapKho] ON 

INSERT [dbo].[nhapKho] ([id], [tenNguyenLieu], [ngayNhap], [soLuong], [donGia]) VALUES (1, N'Gà', N'2023-11-11', 4, 4000)
INSERT [dbo].[nhapKho] ([id], [tenNguyenLieu], [ngayNhap], [soLuong], [donGia]) VALUES (2, N'Bò', N'2023-11-11', 2, 9000)
INSERT [dbo].[nhapKho] ([id], [tenNguyenLieu], [ngayNhap], [soLuong], [donGia]) VALUES (3, N'Vịt', N'2023-11-11', 3, 3000)
INSERT [dbo].[nhapKho] ([id], [tenNguyenLieu], [ngayNhap], [soLuong], [donGia]) VALUES (4, N'Nấm', N'2023-11-11', 1, 100)
INSERT [dbo].[nhapKho] ([id], [tenNguyenLieu], [ngayNhap], [soLuong], [donGia]) VALUES (5, N'Heo', N'2023-04-21', 3, 3000)
SET IDENTITY_INSERT [dbo].[nhapKho] OFF
SET IDENTITY_INSERT [dbo].[PhongAn] ON 

INSERT [dbo].[PhongAn] ([id], [tenPhong], [trangThai]) VALUES (1, N'Phòng VIP 01', N'Đã Đặt')
INSERT [dbo].[PhongAn] ([id], [tenPhong], [trangThai]) VALUES (2, N'Phòng VIP 02', N'Trống')
INSERT [dbo].[PhongAn] ([id], [tenPhong], [trangThai]) VALUES (3, N'Phòng VIP 03', N'Trống')
INSERT [dbo].[PhongAn] ([id], [tenPhong], [trangThai]) VALUES (4, N'Phòng VIP 04', N'Trống')
SET IDENTITY_INSERT [dbo].[PhongAn] OFF
INSERT [dbo].[xuatKho] ([id], [tenNguyenLieu], [soLuongTon]) VALUES (1, N'Gà chiên Xù', 4)
INSERT [dbo].[xuatKho] ([id], [tenNguyenLieu], [soLuongTon]) VALUES (2, N'Bò tái chanh', 2)
INSERT [dbo].[xuatKho] ([id], [tenNguyenLieu], [soLuongTon]) VALUES (3, N'Vịt hầm thuốc bắc ', 3)
INSERT [dbo].[xuatKho] ([id], [tenNguyenLieu], [soLuongTon]) VALUES (4, N'Nấm mèo xào mỡ', 1)
ALTER TABLE [dbo].[ctHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ctHoaDon_hoaDon1] FOREIGN KEY([idHD])
REFERENCES [dbo].[hoaDon] ([id])
GO
ALTER TABLE [dbo].[ctHoaDon] CHECK CONSTRAINT [FK_ctHoaDon_hoaDon1]
GO
ALTER TABLE [dbo].[ctHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ctHoaDon_monAn1] FOREIGN KEY([idMon])
REFERENCES [dbo].[monAn] ([id])
GO
ALTER TABLE [dbo].[ctHoaDon] CHECK CONSTRAINT [FK_ctHoaDon_monAn1]
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
ALTER TABLE [dbo].[hoaDon]  WITH CHECK ADD  CONSTRAINT [FK_hoaDon_banAn1] FOREIGN KEY([idBan])
REFERENCES [dbo].[banAn] ([id])
GO
ALTER TABLE [dbo].[hoaDon] CHECK CONSTRAINT [FK_hoaDon_banAn1]
GO
ALTER TABLE [dbo].[hoaDon]  WITH CHECK ADD  CONSTRAINT [FK_hoaDon_PhongAn1] FOREIGN KEY([idPhong])
REFERENCES [dbo].[PhongAn] ([id])
GO
ALTER TABLE [dbo].[hoaDon] CHECK CONSTRAINT [FK_hoaDon_PhongAn1]
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
/****** Object:  Trigger [dbo].[update_table_status]    Script Date: 4/21/2023 11:08:11 AM ******/
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
/****** Object:  Trigger [dbo].[update_room_status]    Script Date: 4/21/2023 11:08:11 AM ******/
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
/****** Object:  Trigger [dbo].[update_ban_sautt_trigger]    Script Date: 4/21/2023 11:08:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TRIGGER [dbo].[update_ban_sautt_trigger]
ON [dbo].[hoaDon]
AFTER UPDATE
AS
BEGIN
    UPDATE banAn
    SET trang_Thai = N'Trống'
    FROM INSERTED i
    WHERE i.idBan = banAn.id AND i.status = 1
END

GO
/****** Object:  Trigger [dbo].[update_ban_trigger]    Script Date: 4/21/2023 11:08:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TRIGGER [dbo].[update_ban_trigger]
ON [dbo].[hoaDon]
AFTER INSERT
AS
BEGIN
    UPDATE banAn
    SET trang_Thai = N'Có người'
    WHERE id = (SELECT idBan FROM INSERTED where status=0)
END

GO
/****** Object:  Trigger [dbo].[update_Phong_sautt_trigger]    Script Date: 4/21/2023 11:08:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create TRIGGER [dbo].[update_Phong_sautt_trigger]
ON [dbo].[hoaDon]
AFTER UPDATE
AS
BEGIN
    UPDATE PhongAn
    SET trangThai = N'Trống'
    FROM INSERTED i
    WHERE i.idPhong = PhongAn.id AND i.status = 1
END

GO
/****** Object:  Trigger [dbo].[update_Phong_trigger]    Script Date: 4/21/2023 11:08:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create TRIGGER [dbo].[update_Phong_trigger]
ON [dbo].[hoaDon]
AFTER INSERT
AS
BEGIN
    UPDATE PhongAn
    SET trangThai = N'Có người'
    WHERE id = (SELECT idPhong FROM INSERTED where status=0)
END

GO
