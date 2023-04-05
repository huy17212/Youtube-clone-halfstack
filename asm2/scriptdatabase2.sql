USE [master]
GO
/****** Object:  Database [asmJava42]    Script Date: 4/5/2023 7:46:36 PM ******/
CREATE DATABASE [asmJava42]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'asmJava42', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\asmJava42.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'asmJava42_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\asmJava42_log.ldf' , SIZE = 2048KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [asmJava42] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [asmJava42].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [asmJava42] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [asmJava42] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [asmJava42] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [asmJava42] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [asmJava42] SET ARITHABORT OFF 
GO
ALTER DATABASE [asmJava42] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [asmJava42] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [asmJava42] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [asmJava42] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [asmJava42] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [asmJava42] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [asmJava42] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [asmJava42] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [asmJava42] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [asmJava42] SET  DISABLE_BROKER 
GO
ALTER DATABASE [asmJava42] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [asmJava42] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [asmJava42] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [asmJava42] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [asmJava42] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [asmJava42] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [asmJava42] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [asmJava42] SET RECOVERY FULL 
GO
ALTER DATABASE [asmJava42] SET  MULTI_USER 
GO
ALTER DATABASE [asmJava42] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [asmJava42] SET DB_CHAINING OFF 
GO
ALTER DATABASE [asmJava42] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [asmJava42] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [asmJava42] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'asmJava42', N'ON'
GO
USE [asmJava42]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 4/5/2023 7:46:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Account](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[accountusername] [char](10) NOT NULL,
	[email] [varchar](100) NOT NULL,
	[accountpassword] [varchar](50) NOT NULL,
	[avatar] [varchar](20) NOT NULL,
	[isadmin] [bit] NOT NULL,
	[isactive] [bit] NOT NULL,
	[datecreate] [datetime] NULL,
	[dateupdate] [datetime] NULL,
	[nameChannel] [nvarchar](50) NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[History]    Script Date: 4/5/2023 7:46:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[History](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[accountid] [int] NOT NULL,
	[videoid] [int] NOT NULL,
	[vieweddate] [datetime] NULL,
	[isliked] [bit] NOT NULL,
	[comment] [nvarchar](max) NULL,
	[isshare] [bit] NOT NULL,
	[islater] [bit] NULL,
 CONSTRAINT [PK_History] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Repository]    Script Date: 4/5/2023 7:46:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Repository](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[accountid] [int] NOT NULL,
	[videoid] [int] NOT NULL,
	[datecreate] [datetime] NULL,
	[statusid] [int] NOT NULL,
	[dateupdate] [datetime] NULL,
 CONSTRAINT [PK_Repository] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[RepositoryStatus]    Script Date: 4/5/2023 7:46:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RepositoryStatus](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[status] [nchar](10) NOT NULL,
 CONSTRAINT [PK_RepositoryStatus] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Subcriber]    Script Date: 4/5/2023 7:46:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Subcriber](
	[accountid] [int] NOT NULL,
	[listsubcriber] [varchar](500) NOT NULL,
 CONSTRAINT [PK_Subcriber] PRIMARY KEY CLUSTERED 
(
	[accountid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Video]    Script Date: 4/5/2023 7:46:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Video](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](100) NOT NULL,
	[discription] [nvarchar](500) NOT NULL,
	[href] [varchar](50) NOT NULL,
	[poster] [varchar](20) NOT NULL,
	[views] [int] NOT NULL,
	[shares] [int] NOT NULL,
	[isactive] [bit] NOT NULL,
	[likenumber] [int] NOT NULL,
	[commentnumber] [int] NULL,
	[hashtag] [nvarchar](20) NOT NULL,
	[datecreate] [datetime] NULL,
	[dateupdate] [datetime] NULL,
	[uploader] [nvarchar](50) NULL,
 CONSTRAINT [PK_Video] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Account] ON 

INSERT [dbo].[Account] ([id], [accountusername], [email], [accountpassword], [avatar], [isadmin], [isactive], [datecreate], [dateupdate], [nameChannel]) VALUES (3, N'accUser   ', N'hahuytri2K3@gmail.com', N'abc', N'accountUser.png', 0, 1, NULL, NULL, N'Duy Tran')
INSERT [dbo].[Account] ([id], [accountusername], [email], [accountpassword], [avatar], [isadmin], [isactive], [datecreate], [dateupdate], [nameChannel]) VALUES (4, N'accAdmin  ', N'hahuytri2K3@gmail.com', N'abc', N'accountAdmin.png', 1, 1, NULL, NULL, N'Vladimir')
INSERT [dbo].[Account] ([id], [accountusername], [email], [accountpassword], [avatar], [isadmin], [isactive], [datecreate], [dateupdate], [nameChannel]) VALUES (10, N'accUser2  ', N'hahuytri2K3@gmail.com', N'abc', N'gerard.png', 0, 1, NULL, NULL, N'Ha Huy Tri')
INSERT [dbo].[Account] ([id], [accountusername], [email], [accountpassword], [avatar], [isadmin], [isactive], [datecreate], [dateupdate], [nameChannel]) VALUES (1010, N'accUser3  ', N'hahuytri2K3@gmail.com', N'abc', N'Jack.png', 0, 1, CAST(N'2023-03-29 00:00:00.000' AS DateTime), CAST(N'2023-03-29 00:00:00.000' AS DateTime), N'JackVietNam')
INSERT [dbo].[Account] ([id], [accountusername], [email], [accountpassword], [avatar], [isadmin], [isactive], [datecreate], [dateupdate], [nameChannel]) VALUES (1011, N'accUser4  ', N'hahuytri2K3@gmail.com', N'abc', N'megan.png', 0, 1, CAST(N'2023-04-01 00:00:00.000' AS DateTime), CAST(N'2023-04-01 00:00:00.000' AS DateTime), N'Jimmy')
SET IDENTITY_INSERT [dbo].[Account] OFF
SET IDENTITY_INSERT [dbo].[History] ON 

INSERT [dbo].[History] ([id], [accountid], [videoid], [vieweddate], [isliked], [comment], [isshare], [islater]) VALUES (1, 3, 2, NULL, 1, NULL, 1, 1)
INSERT [dbo].[History] ([id], [accountid], [videoid], [vieweddate], [isliked], [comment], [isshare], [islater]) VALUES (2, 3, 3, NULL, 1, NULL, 1, 1)
INSERT [dbo].[History] ([id], [accountid], [videoid], [vieweddate], [isliked], [comment], [isshare], [islater]) VALUES (3, 3, 4, NULL, 1, NULL, 1, 1)
INSERT [dbo].[History] ([id], [accountid], [videoid], [vieweddate], [isliked], [comment], [isshare], [islater]) VALUES (4, 3, 7, NULL, 1, NULL, 1, 0)
INSERT [dbo].[History] ([id], [accountid], [videoid], [vieweddate], [isliked], [comment], [isshare], [islater]) VALUES (5, 3, 5, NULL, 1, NULL, 0, 0)
INSERT [dbo].[History] ([id], [accountid], [videoid], [vieweddate], [isliked], [comment], [isshare], [islater]) VALUES (6, 3, 6, NULL, 1, NULL, 1, 1)
INSERT [dbo].[History] ([id], [accountid], [videoid], [vieweddate], [isliked], [comment], [isshare], [islater]) VALUES (7, 10, 7, NULL, 1, NULL, 0, 0)
INSERT [dbo].[History] ([id], [accountid], [videoid], [vieweddate], [isliked], [comment], [isshare], [islater]) VALUES (8, 10, 3, NULL, 0, NULL, 0, 0)
INSERT [dbo].[History] ([id], [accountid], [videoid], [vieweddate], [isliked], [comment], [isshare], [islater]) VALUES (41, 3, 17, NULL, 1, NULL, 1, 1)
INSERT [dbo].[History] ([id], [accountid], [videoid], [vieweddate], [isliked], [comment], [isshare], [islater]) VALUES (42, 3, 18, NULL, 0, NULL, 0, 0)
INSERT [dbo].[History] ([id], [accountid], [videoid], [vieweddate], [isliked], [comment], [isshare], [islater]) VALUES (1004, 1010, 1009, NULL, 0, NULL, 0, 0)
INSERT [dbo].[History] ([id], [accountid], [videoid], [vieweddate], [isliked], [comment], [isshare], [islater]) VALUES (1005, 1010, 1008, NULL, 1, NULL, 0, 0)
INSERT [dbo].[History] ([id], [accountid], [videoid], [vieweddate], [isliked], [comment], [isshare], [islater]) VALUES (1007, 3, 1009, NULL, 1, NULL, 1, 1)
INSERT [dbo].[History] ([id], [accountid], [videoid], [vieweddate], [isliked], [comment], [isshare], [islater]) VALUES (1008, 10, 1008, NULL, 1, NULL, 0, 0)
INSERT [dbo].[History] ([id], [accountid], [videoid], [vieweddate], [isliked], [comment], [isshare], [islater]) VALUES (1009, 10, 1009, NULL, 1, NULL, 0, 0)
INSERT [dbo].[History] ([id], [accountid], [videoid], [vieweddate], [isliked], [comment], [isshare], [islater]) VALUES (1010, 10, 5, NULL, 1, NULL, 0, 0)
INSERT [dbo].[History] ([id], [accountid], [videoid], [vieweddate], [isliked], [comment], [isshare], [islater]) VALUES (1011, 1010, 5, NULL, 1, NULL, 0, 0)
INSERT [dbo].[History] ([id], [accountid], [videoid], [vieweddate], [isliked], [comment], [isshare], [islater]) VALUES (1012, 1010, 6, NULL, 1, NULL, 0, 0)
INSERT [dbo].[History] ([id], [accountid], [videoid], [vieweddate], [isliked], [comment], [isshare], [islater]) VALUES (1013, 1010, 7, NULL, 1, NULL, 0, 0)
INSERT [dbo].[History] ([id], [accountid], [videoid], [vieweddate], [isliked], [comment], [isshare], [islater]) VALUES (1014, 1010, 4, NULL, 1, NULL, 0, 0)
INSERT [dbo].[History] ([id], [accountid], [videoid], [vieweddate], [isliked], [comment], [isshare], [islater]) VALUES (1015, 1010, 17, NULL, 0, NULL, 0, 0)
INSERT [dbo].[History] ([id], [accountid], [videoid], [vieweddate], [isliked], [comment], [isshare], [islater]) VALUES (1016, 10, 2, NULL, 0, NULL, 0, 0)
INSERT [dbo].[History] ([id], [accountid], [videoid], [vieweddate], [isliked], [comment], [isshare], [islater]) VALUES (1017, 10, 6, NULL, 0, NULL, 0, 0)
INSERT [dbo].[History] ([id], [accountid], [videoid], [vieweddate], [isliked], [comment], [isshare], [islater]) VALUES (1018, 3, 1008, CAST(N'2023-04-01 00:00:00.000' AS DateTime), 1, NULL, 1, 1)
SET IDENTITY_INSERT [dbo].[History] OFF
SET IDENTITY_INSERT [dbo].[Repository] ON 

INSERT [dbo].[Repository] ([id], [accountid], [videoid], [datecreate], [statusid], [dateupdate]) VALUES (1, 3, 2, NULL, 3, NULL)
INSERT [dbo].[Repository] ([id], [accountid], [videoid], [datecreate], [statusid], [dateupdate]) VALUES (2, 3, 3, NULL, 3, NULL)
INSERT [dbo].[Repository] ([id], [accountid], [videoid], [datecreate], [statusid], [dateupdate]) VALUES (3, 3, 4, NULL, 3, NULL)
INSERT [dbo].[Repository] ([id], [accountid], [videoid], [datecreate], [statusid], [dateupdate]) VALUES (4, 3, 5, CAST(N'2023-03-26 00:00:00.000' AS DateTime), 3, CAST(N'2023-03-26 00:00:00.000' AS DateTime))
INSERT [dbo].[Repository] ([id], [accountid], [videoid], [datecreate], [statusid], [dateupdate]) VALUES (5, 3, 6, CAST(N'2023-03-27 05:26:58.120' AS DateTime), 3, CAST(N'2023-03-27 05:26:58.120' AS DateTime))
INSERT [dbo].[Repository] ([id], [accountid], [videoid], [datecreate], [statusid], [dateupdate]) VALUES (6, 10, 7, CAST(N'2023-03-27 05:43:21.953' AS DateTime), 3, CAST(N'2023-03-27 05:43:21.953' AS DateTime))
INSERT [dbo].[Repository] ([id], [accountid], [videoid], [datecreate], [statusid], [dateupdate]) VALUES (7, 3, 17, CAST(N'2023-03-28 14:13:08.237' AS DateTime), 3, CAST(N'2023-03-28 14:13:08.237' AS DateTime))
INSERT [dbo].[Repository] ([id], [accountid], [videoid], [datecreate], [statusid], [dateupdate]) VALUES (8, 3, 18, CAST(N'2023-03-28 14:32:47.160' AS DateTime), 3, CAST(N'2023-03-28 14:32:47.160' AS DateTime))
INSERT [dbo].[Repository] ([id], [accountid], [videoid], [datecreate], [statusid], [dateupdate]) VALUES (1094, 3, 2, CAST(N'2023-04-01 14:03:24.287' AS DateTime), 2, CAST(N'2023-04-01 14:03:24.287' AS DateTime))
INSERT [dbo].[Repository] ([id], [accountid], [videoid], [datecreate], [statusid], [dateupdate]) VALUES (1096, 3, 1009, CAST(N'2023-04-01 14:18:41.057' AS DateTime), 2, CAST(N'2023-04-01 14:18:41.057' AS DateTime))
INSERT [dbo].[Repository] ([id], [accountid], [videoid], [datecreate], [statusid], [dateupdate]) VALUES (1097, 3, 4, CAST(N'2023-04-02 05:49:00.523' AS DateTime), 2, CAST(N'2023-04-02 05:49:00.523' AS DateTime))
INSERT [dbo].[Repository] ([id], [accountid], [videoid], [datecreate], [statusid], [dateupdate]) VALUES (1098, 3, 17, CAST(N'2023-04-02 05:54:11.973' AS DateTime), 2, CAST(N'2023-04-02 05:54:11.973' AS DateTime))
INSERT [dbo].[Repository] ([id], [accountid], [videoid], [datecreate], [statusid], [dateupdate]) VALUES (1099, 3, 3, CAST(N'2023-04-02 13:16:32.257' AS DateTime), 2, CAST(N'2023-04-02 13:16:32.257' AS DateTime))
INSERT [dbo].[Repository] ([id], [accountid], [videoid], [datecreate], [statusid], [dateupdate]) VALUES (1100, 3, 1008, CAST(N'2023-04-05 05:35:55.777' AS DateTime), 2, CAST(N'2023-04-05 05:35:55.777' AS DateTime))
INSERT [dbo].[Repository] ([id], [accountid], [videoid], [datecreate], [statusid], [dateupdate]) VALUES (1101, 3, 6, CAST(N'2023-04-05 05:35:55.777' AS DateTime), 2, CAST(N'2023-04-05 05:35:55.777' AS DateTime))
SET IDENTITY_INSERT [dbo].[Repository] OFF
SET IDENTITY_INSERT [dbo].[RepositoryStatus] ON 

INSERT [dbo].[RepositoryStatus] ([id], [status]) VALUES (1, N'share     ')
INSERT [dbo].[RepositoryStatus] ([id], [status]) VALUES (2, N'later     ')
INSERT [dbo].[RepositoryStatus] ([id], [status]) VALUES (3, N'upload    ')
SET IDENTITY_INSERT [dbo].[RepositoryStatus] OFF
INSERT [dbo].[Subcriber] ([accountid], [listsubcriber]) VALUES (3, N'1011,10')
INSERT [dbo].[Subcriber] ([accountid], [listsubcriber]) VALUES (10, N'')
INSERT [dbo].[Subcriber] ([accountid], [listsubcriber]) VALUES (1010, N'')
INSERT [dbo].[Subcriber] ([accountid], [listsubcriber]) VALUES (1011, N'')
SET IDENTITY_INSERT [dbo].[Video] ON 

INSERT [dbo].[Video] ([id], [title], [discription], [href], [poster], [views], [shares], [isactive], [likenumber], [commentnumber], [hashtag], [datecreate], [dateupdate], [uploader]) VALUES (2, N'Phá đảo ASM Java 4 - Phần 1: Tạo DB map entity và dựng các hàm common', N'Trong video này mình hướng dẫn tạo DB map entity và dựng các hàm common: <br>00:00 - Phân tích đề bài 05:51 - Tạo DB trên SQL Server <br> 23:13 - Tải templates <br> 27:42 - Create maven project import thư viện <br> 39:50 - Cấu trúc project theo mô hình 3 lớp <br> 51:53 - Mapping entities <br>01:07:51 - Create JpaUtil <br> 01:10:38 - Create AbstractDao chứa các hàm query', N'9wrBeWc944U', N'video11.png', 40, 1, 1, 1, 0, N'study', CAST(N'2023-12-24 00:00:00.000' AS DateTime), CAST(N'2023-12-24 00:00:00.000' AS DateTime), N'Duy Tran')
INSERT [dbo].[Video] ([id], [title], [discription], [href], [poster], [views], [shares], [isactive], [likenumber], [commentnumber], [hashtag], [datecreate], [dateupdate], [uploader]) VALUES (3, N'Phá đảo ASM Java 4 - Phần 2.2: Code đăng ký, đăng nhập, đăng xuất', N'Phần này mình hoàn thiện các chức năng đăng ký, đăng nhập, đăng xuất phía người dùng với các nội dung sau:<br>
00:00 - Tạo UserService
<br>10:55 - Tạo giao diện login.jsp<br>
13:26 - Tạo UserController, chức năng đăng nhập
<br>32:45 - Xử lý hiển thị menu bằng JSTL
<br>39:42 - Chức năng đăng ký<br>
47:40 - Chức năng đăng xuất', N'fBjD66UtNZk', N'video21.png', 16, 1, 1, 1, 0, N'study', CAST(N'2023-12-24 00:00:00.000' AS DateTime), CAST(N'2023-03-24 00:00:00.000' AS DateTime), N'Duy Tran')
INSERT [dbo].[Video] ([id], [title], [discription], [href], [poster], [views], [shares], [isactive], [likenumber], [commentnumber], [hashtag], [datecreate], [dateupdate], [uploader]) VALUES (4, N'Phá đảo ASM Java 4 - Phần 2.1: Code lớp DAO, Service và trang index', N'Ở video này chúng ta cùng code các lớp Dao, Service và chạy trang index lên:
<br>00:00 - UserDao
<br>11:44 - VideoDao<br>
16:59 - HistoryDao<br>
30:50 - VideoService<br>
41:43 - Tạo giao diện index<br>
01:05:59 - Gọi list video ở HomeController<br>
01:08:35 - Sử dụng JSTL hiển thị list video', N'mTkHbyQKT5w', N'video12.png', 16, 1, 1, 3, 0, N'study', CAST(N'2023-03-24 00:00:00.000' AS DateTime), CAST(N'2023-03-24 00:00:00.000' AS DateTime), N'Duy Tran')
INSERT [dbo].[Video] ([id], [title], [discription], [href], [poster], [views], [shares], [isactive], [likenumber], [commentnumber], [hashtag], [datecreate], [dateupdate], [uploader]) VALUES (5, N'video', N'dasdsa', N'5iEvOqxYfKc', N'anh4.jpg', 12, 0, 1, 3, 0, N'video', CAST(N'2023-03-26 00:00:00.000' AS DateTime), CAST(N'2023-03-26 00:00:00.000' AS DateTime), N'Duy Tran')
INSERT [dbo].[Video] ([id], [title], [discription], [href], [poster], [views], [shares], [isactive], [likenumber], [commentnumber], [hashtag], [datecreate], [dateupdate], [uploader]) VALUES (6, N'Anh Không muốn ra đi Nguyễn Phi Hùng', N'Best Video Music', N'6AKngUUz2L8', N'video4.png', 18, 0, 1, 2, 0, N'song', CAST(N'2023-03-27 00:00:00.000' AS DateTime), CAST(N'2023-03-27 00:00:00.000' AS DateTime), N'Duy Tran')
INSERT [dbo].[Video] ([id], [title], [discription], [href], [poster], [views], [shares], [isactive], [likenumber], [commentnumber], [hashtag], [datecreate], [dateupdate], [uploader]) VALUES (7, N'Hymn for the Weekend_Is''t Cool play', N'Best Song ever', N'jA5grJwRAy4', N'video3.png', 34, 0, 1, 3, 0, N'song', CAST(N'2023-03-27 00:00:00.000' AS DateTime), CAST(N'2023-03-27 00:00:00.000' AS DateTime), N'Ha Huy Tri')
INSERT [dbo].[Video] ([id], [title], [discription], [href], [poster], [views], [shares], [isactive], [likenumber], [commentnumber], [hashtag], [datecreate], [dateupdate], [uploader]) VALUES (17, N'Tutor video', N'Best way to ajax for website', N'BGAHQi8S-qI', N'video3.png', 10, 1, 1, 1, 0, N'study', CAST(N'2023-03-28 00:00:00.000' AS DateTime), CAST(N'2023-03-28 00:00:00.000' AS DateTime), N'Duy Tran')
INSERT [dbo].[Video] ([id], [title], [discription], [href], [poster], [views], [shares], [isactive], [likenumber], [commentnumber], [hashtag], [datecreate], [dateupdate], [uploader]) VALUES (18, N'RE4', N'DeoCT', N'BGAHQi8S-qI', N'video5.png', 4, 0, 1, 0, 0, N'game', CAST(N'2023-03-28 00:00:00.000' AS DateTime), CAST(N'2023-03-28 00:00:00.000' AS DateTime), N'Duy Tran')
INSERT [dbo].[Video] ([id], [title], [discription], [href], [poster], [views], [shares], [isactive], [likenumber], [commentnumber], [hashtag], [datecreate], [dateupdate], [uploader]) VALUES (1008, N'I don''t want to leave', N'Vang trang xua in bong noi co don tren phim dan', N'r2B6opdKKIw', N'anhkhongmuonradi.jpg', 9, 3, 1, 5, 0, N'song', CAST(N'2023-03-29 00:00:00.000' AS DateTime), CAST(N'2023-03-29 00:00:00.000' AS DateTime), N'Duy Tran')
INSERT [dbo].[Video] ([id], [title], [discription], [href], [poster], [views], [shares], [isactive], [likenumber], [commentnumber], [hashtag], [datecreate], [dateupdate], [uploader]) VALUES (1009, N'Streak best song of Jimmy Nguyen', N'Lien khuc hay nhat cua Jimmy Nguyen <br> Tuyet voi ong mat troi', N'iVjvBF5Xca4', N'jack2.jpg', 10, -4, 1, 2, 0, N'song', CAST(N'2023-03-29 00:00:00.000' AS DateTime), CAST(N'2023-03-29 00:00:00.000' AS DateTime), N'JackVietNam')
SET IDENTITY_INSERT [dbo].[Video] OFF
ALTER TABLE [dbo].[History]  WITH CHECK ADD  CONSTRAINT [FK_History_Account] FOREIGN KEY([accountid])
REFERENCES [dbo].[Account] ([id])
GO
ALTER TABLE [dbo].[History] CHECK CONSTRAINT [FK_History_Account]
GO
ALTER TABLE [dbo].[History]  WITH CHECK ADD  CONSTRAINT [FK_History_Video] FOREIGN KEY([videoid])
REFERENCES [dbo].[Video] ([id])
GO
ALTER TABLE [dbo].[History] CHECK CONSTRAINT [FK_History_Video]
GO
ALTER TABLE [dbo].[Repository]  WITH CHECK ADD  CONSTRAINT [FK_Repository_Account] FOREIGN KEY([accountid])
REFERENCES [dbo].[Account] ([id])
GO
ALTER TABLE [dbo].[Repository] CHECK CONSTRAINT [FK_Repository_Account]
GO
ALTER TABLE [dbo].[Repository]  WITH CHECK ADD  CONSTRAINT [FK_Repository_RepositoryStatus] FOREIGN KEY([statusid])
REFERENCES [dbo].[RepositoryStatus] ([id])
GO
ALTER TABLE [dbo].[Repository] CHECK CONSTRAINT [FK_Repository_RepositoryStatus]
GO
ALTER TABLE [dbo].[Repository]  WITH CHECK ADD  CONSTRAINT [FK_Repository_Video] FOREIGN KEY([videoid])
REFERENCES [dbo].[Video] ([id])
GO
ALTER TABLE [dbo].[Repository] CHECK CONSTRAINT [FK_Repository_Video]
GO
ALTER TABLE [dbo].[Subcriber]  WITH CHECK ADD  CONSTRAINT [FK_Subcriber_Account] FOREIGN KEY([accountid])
REFERENCES [dbo].[Account] ([id])
GO
ALTER TABLE [dbo].[Subcriber] CHECK CONSTRAINT [FK_Subcriber_Account]
GO
USE [master]
GO
ALTER DATABASE [asmJava42] SET  READ_WRITE 
GO
