USE [master]
GO

PRINT 'Create database SOSS'
GO

IF EXISTS (SELECT name FROM sys.databases WHERE name = N'SOSS')
BEGIN
    ALTER DATABASE [SOSS] SET SINGLE_USER WITH ROLLBACK IMMEDIATE
    DROP DATABASE [SOSS]
END
GO

CREATE DATABASE [SOSS] COLLATE Cyrillic_General_CI_AS
GO

ALTER DATABASE [SOSS]
SET ALLOW_SNAPSHOT_ISOLATION ON

ALTER DATABASE [SOSS]
SET READ_COMMITTED_SNAPSHOT ON
GO

USE [SOSS]
GO

PRINT 'Create Tasks'
GO

CREATE TABLE [dbo].[Tasks] (
    [TaskId]                    INT                 NOT NULL IDENTITY,
    [Name]                      NVARCHAR (MAX)      NOT NULL,
    [Priority]                  INT                 NOT NULL,
    [Description]               NVARCHAR (MAX)      NOT NULL,

    CONSTRAINT [PK_Tasks]                           PRIMARY KEY ([TaskId])
);
GO

PRINT 'Insert Tasks'
GO

INSERT INTO [Tasks]
    ([Name]               , [Priority], [Description]                  )
VALUES
    (N'Задача 1'          , 1         , N'Описание на задача 1'        ),
    (N'Задача 2'          , 2         , N'Описание на задача 2'        ),
    (N'Задача 3'          , 3         , N'Описание на задача 3'        )
GO
