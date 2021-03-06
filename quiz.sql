USE [EasyCMS]
GO
/****** Object:  Table [dbo].[Question]    Script Date: 5/14/2020 11:32:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Question](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[content] [nvarchar](500) NULL,
	[option1] [nvarchar](500) NULL,
	[option2] [nvarchar](500) NULL,
	[option3] [nvarchar](500) NULL,
	[option4] [nvarchar](500) NULL,
	[answer] [nvarchar](500) NULL,
	[created] [date] NULL,
 CONSTRAINT [PK__Question__3213E83F5C3138FD] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[QuizHistory]    Script Date: 5/14/2020 11:32:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[QuizHistory](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[studenID] [int] NOT NULL,
	[score] [nchar](10) NULL,
	[status] [nchar](10) NULL,
 CONSTRAINT [PK_QuizHistory_1] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 5/14/2020 11:32:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NULL,
	[password] [varchar](50) NULL,
	[email] [varchar](50) NULL,
	[type] [bit] NULL,
 CONSTRAINT [PK__Users__3213E83FDFB2E99E] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Question] ON 

INSERT [dbo].[Question] ([id], [content], [option1], [option2], [option3], [option4], [answer], [created]) VALUES (50, N'dgdfg', N'fdg', N'fdgfd', N'gfdg', N'dfgfd', N'1', CAST(N'2020-03-28' AS Date))
INSERT [dbo].[Question] ([id], [content], [option1], [option2], [option3], [option4], [answer], [created]) VALUES (53, N'Người yêu thiên văn sắp có cơ hội chiêm ngưỡng siêu trăng, hiện tượng xảy ra khi trăng tròn gần trùng với cận điểm (điểm gần Trái Đất nhất trên quỹ đạo Mặt Trăng), khiến nó trông lớn và sáng hơn bình thường.', N'Người yêu thiên văn sắp có cơ hội chiêm ngưỡng siêu trăng, hiện tượng xảy ra khi trăng tròn gần trùng với cận điểm (điểm gần Trái Đất nhất trên quỹ đạo Mặt Trăng), khiến nó trông lớn và sáng hơn bình thường.', N'Người yêu thiên văn sắp có cơ hội chiêm ngưỡng siêu trăng, hiện tượng xảy ra khi trăng tròn gần trùng với cận điểm (điểm gần Trái Đất nhất trên quỹ đạo Mặt Trăng), khiến nó trông lớn và sáng hơn bình thường.', N'Người yêu thiên văn sắp có cơ hội chiêm ngưỡng siêu trăng, hiện tượng xảy ra khi trăng tròn gần trùng với cận điểm (điểm gần Trái Đất nhất trên quỹ đạo Mặt Trăng), khiến nó trông lớn và sáng hơn bình thường.', N'Người yêu thiên văn sắp có cơ hội chiêm ngưỡng siêu trăng, hiện tượng xảy ra khi trăng tròn gần trùng với cận điểm (điểm gần Trái Đất nhất trên quỹ đạo Mặt Trăng), khiến nó trông lớn và sáng hơn bình thường.', N'1', CAST(N'2020-04-01' AS Date))
INSERT [dbo].[Question] ([id], [content], [option1], [option2], [option3], [option4], [answer], [created]) VALUES (54, N'q', N'q', N'q', N'q', N'q', N'2', CAST(N'2020-04-03' AS Date))
INSERT [dbo].[Question] ([id], [content], [option1], [option2], [option3], [option4], [answer], [created]) VALUES (55, N'q', N'q', N'qq', N'q', N'q', N'1', CAST(N'2020-04-03' AS Date))
INSERT [dbo].[Question] ([id], [content], [option1], [option2], [option3], [option4], [answer], [created]) VALUES (56, N'q', N'qqq', N'q', N'q', N'q', N'2', CAST(N'2020-04-03' AS Date))
INSERT [dbo].[Question] ([id], [content], [option1], [option2], [option3], [option4], [answer], [created]) VALUES (58, N'q', N'q', N'q', N'q', N'q', N'123', CAST(N'2020-04-04' AS Date))
SET IDENTITY_INSERT [dbo].[Question] OFF
SET IDENTITY_INSERT [dbo].[QuizHistory] ON 

INSERT [dbo].[QuizHistory] ([id], [studenID], [score], [status]) VALUES (4, 6, N'5         ', N'Pass      ')
INSERT [dbo].[QuizHistory] ([id], [studenID], [score], [status]) VALUES (5, 6, N'0         ', N'Fail      ')
INSERT [dbo].[QuizHistory] ([id], [studenID], [score], [status]) VALUES (6, 6, N'0         ', N'Fail      ')
INSERT [dbo].[QuizHistory] ([id], [studenID], [score], [status]) VALUES (7, 6, N'          ', N'reject    ')
INSERT [dbo].[QuizHistory] ([id], [studenID], [score], [status]) VALUES (8, 6, N'0         ', N'Fail      ')
INSERT [dbo].[QuizHistory] ([id], [studenID], [score], [status]) VALUES (9, 6, N'          ', N'reject    ')
SET IDENTITY_INSERT [dbo].[QuizHistory] OFF
SET IDENTITY_INSERT [dbo].[Users] ON 

INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (6, N'thaoqs', N'1', N'alo@gmail.com', 1)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1006, N'quyxanh019', N'12345678', N'huyhoangbluedemon019@gmail.com', 0)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1007, N'thaoqs11', N'1', N'alo@gmail.com', 0)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1008, N'thaoqs111', N'1', N'alo@gmail.com', 0)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1010, N'12', N'12', N'quang@gmail.com', 1)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1011, N'22', N'22', N'huyhoangbluedemon019@gmail.com', 0)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1012, N'admin', N'Ã¡d', N'khjk@gmail.com', 0)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1013, N'abc', N'1', N'khjk@gmail.com', 1)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1014, N'cde', N'1', N'huyhoangbluedemon019@gmail.com', 0)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1015, N'a', N'1', N'1@gmail.com', 0)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1016, N'b', N'1', N'1@gmail.com', 1)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1017, N'hs', N'1', N'alo@gmail.com', 0)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1018, N'qwer', N'qwer', N'sdsccssdd@gmail.com', 0)
SET IDENTITY_INSERT [dbo].[Users] OFF
ALTER TABLE [dbo].[Question] ADD  CONSTRAINT [DF__Question__create__3B75D760]  DEFAULT (getdate()) FOR [created]
GO
ALTER TABLE [dbo].[QuizHistory]  WITH CHECK ADD  CONSTRAINT [FK_QuizHistory_Users] FOREIGN KEY([studenID])
REFERENCES [dbo].[Users] ([id])
GO
ALTER TABLE [dbo].[QuizHistory] CHECK CONSTRAINT [FK_QuizHistory_Users]
GO
