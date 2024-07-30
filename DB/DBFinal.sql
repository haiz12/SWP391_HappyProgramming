
USE swp
GO

USE [master];
GO

IF EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'swp')
BEGIN
    ALTER DATABASE swp SET OFFLINE WITH ROLLBACK IMMEDIATE;
    ALTER DATABASE swp SET ONLINE;
    DROP DATABASE swp;
END;
GO

CREATE DATABASE swp;
GO

USE swp;
GO

CREATE TABLE account
(
    idAccount INT IDENTITY(1, 1) PRIMARY KEY,
    username VARCHAR(255) NOT NULL
        UNIQUE,
    email VARCHAR(255),
    password VARCHAR(MAX),
    role NVARCHAR(10),
    confirm INT
        DEFAULT 0,
    active BIT
        DEFAULT 1
);
GO

INSERT INTO dbo.account
(
    username,
    email,
    password,
    role,
    confirm
)
VALUES
('user1', 'user1@gmail.com', '123', 'Mentor', 1),
('user2', 'user2@gmail.com', '123', 'Mentor', 1),
('user3', 'user3@gmail.com', '123', 'Mentor', 1),
('user4', 'user4@gmail.com', '123', 'Mentor', 1),
('user5', 'user5@gmail.com', '123', 'Mentor', 1),
('user6', 'user6@gmail.com', '123', 'Mentor', 1),
('user7', 'user7@gmail.com', '123', 'Mentee', 1),
('user8', 'user8@gmail.com', '123', 'Mentee', 1),
('user9', 'user9@gmail.com', '123', 'Mentee', 1),
('user10', 'user10@gmail.com', '123', 'Mentee', 1),
('user11', 'user11@gmail.com', '123', 'Mentee', 1),
('user12', 'user12@gmail.com', '123', 'Mentee', 1),
('admin', NULL, 'admin', 'Admin', 1),
('manager', NULL, '123', 'Manager', 1),
('maketer', NULL, '123', 'Maketer', 1);
GO
CREATE TABLE status (
	status_id int primary key,
	note nvarchar(max)
)
GO
INSERT INTO status ( status_id, note) VALUES (0, 'Draft'), (1, 'Submit'), (2, 'Approve'), (3, 'Reject'), (4, 'Cancel'), (5, 'Close'), (6, 'Processing'), (7, 'RequestUpdate'), (8, 'AcceptUpdate'), (9, 'RejectUpdate') ,(10, 'Paymented'), (11, 'RequestDone'), (12, 'ComfirmDone')
GO
CREATE TABLE mentee
(
    idMentee INT
        REFERENCES dbo.account (idAccount) PRIMARY KEY,
    fullname NVARCHAR(MAX),
    avatar VARCHAR(MAX),
    story NVARCHAR(MAX),
    dob DATE,
    phone VARCHAR(10),
    sex VARCHAR(6)
        DEFAULT 'Male',
    experience NVARCHAR(MAX),
    registerDate DATE,
    address NVARCHAR(MAX)
);
GO


INSERT INTO dbo.mentee
(
    idMentee,
    fullname,
    avatar,
    story,
    dob,
    phone,
    sex,
    experience,
    registerDate,
    address
)
VALUES
(7, N'Đinh Thị Thảo', 'img/wo1.jpg',
 N'Tôi là một cá nhân đam mê và sáng tạo, yêu thích nghệ thuật và thể hiện. Với nền tảng về Mỹ thuật và kinh nghiệm trưng bày tác phẩm của mình tại các triển lãm địa phương, tôi không ngừng tìm cách vượt qua ranh giới của sự sáng tạo. Tôi rất vui mừng về cơ hội được kết nối với những người cố vấn, những người có thể giúp tôi khám phá và phát triển hơn nữa tài năng nghệ thuật của mình.',
 '2003-10-19', '0123456789', N'Female',
 N'Có kinh nghiệm về mỹ thuật, thành thạo hội họa, điêu khắc và hợp tác trong các dự án sáng tạo.', '2024-01-18',
 N'Hải Dương'),
(8, N'Nguyễn Nhật Anh', 'img/wo2.jpg',
 N'Tôi là một cá nhân tận tâm và chăm chỉ với niềm đam mê công nghệ và đổi mới. Với bằng Kỹ thuật Máy tính và kinh nghiệm làm nhà phát triển cấp dưới, tôi không ngừng tìm kiếm cơ hội để mở rộng kỹ năng và kiến ​​thức của mình trong lĩnh vực này. Tôi rất vui mừng về khả năng kết nối với những người cố vấn, những người có thể giúp hướng dẫn tôi trên hành trình nghề nghiệp của mình.',
 '2003-08-18', '0123456789', N'Female',
 N'Bằng kỹ thuật máy tính, có kinh nghiệm về thiết kế mạch, lập trình vi điều khiển và phát triển hệ thống nhúng.',
 '2024-01-18', N'Ninh Bình'),
(9, N'Nguyễn Thị Kiều Trang', 'img/wo3.jpg',
 N'Tôi là một cá nhân giàu lòng nhân ái và có ý thức xã hội với mong muốn mạnh mẽ tạo ra sự khác biệt trên thế giới. Với nền tảng về Xã hội học và kinh nghiệm làm tình nguyện viên cho các tổ chức phi chính phủ tập trung vào nhân quyền, tôi cam kết sâu sắc trong việc vận động cho các cộng đồng bị thiệt thòi. Tôi rất vui mừng về cơ hội học hỏi và phát triển thông qua các cơ hội cố vấn cho phép tôi đóng góp hơn nữa vào sự thay đổi tích cực của xã hội.',
 '2003-01-19', '0123456789', N'Female',
 N'Nền tảng về xã hội học, thành thạo các phương pháp nghiên cứu và tình nguyện cho các tổ chức phi chính phủ tập trung vào nhân quyền.',
 '2024-01-18', N'Ninh Bình'),
(10, N'Vũ Văn Nam', 'img/men1.jpg',
 N'Tôi là một cá nhân nhiệt tình, có niềm đam mê học hỏi và khám phá những cơ hội mới. Với nền tảng về Khoa học Máy tính và kinh nghiệm làm nhà phát triển phần mềm trong 2 năm, tôi đã phát triển các kỹ năng giải quyết vấn đề mạnh mẽ và chú ý đến từng chi tiết. Tôi mong muốn tiếp tục mở rộng kiến ​​thức và kỹ năng của mình, cả về mặt cá nhân lẫn nghề nghiệp.',
 '2003-04-18', '0123456789', N'Male',
 N'Có nền tảng về phát triển phần mềm, thành thạo trong việc giải quyết vấn đề và quản lý dự án.', '2024-01-18',
 N'Hải Dương'),
(11, N'Nguyễn Việt Hà', 'img/men2.jpg',
 N'Tôi là một cá nhân có định hướng và đầy tham vọng, quan tâm sâu sắc đến tinh thần kinh doanh và đổi mới kinh doanh. Hiện đang theo học ngành Quản trị Kinh doanh và tích lũy được kinh nghiệm quý báu thông qua các đợt thực tập, tôi không ngừng tìm cách thử thách bản thân và phát triển. Tôi rất hào hứng với cơ hội học hỏi từ những người cố vấn giàu kinh nghiệm và phát triển hơn nữa các kỹ năng của mình.',
 '2003-10-19', '0123456789', N'Male',
 N'Có kinh nghiệm quản trị kinh doanh, thành thạo quản lý dự án và nghiên cứu thị trường.', '2024-01-18', N'Hải Dương'),
(12, N'Đào Duy Việt', 'img/men3.jpg',
 N'Tôi là người ủng hộ tận tâm cho sự bền vững môi trường và trách nhiệm xã hội. Với bằng Khoa học Môi trường và kiến ​​thức nền tảng về các dự án bảo tồn, tôi cam kết sâu sắc sẽ tạo ra tác động tích cực đến thế giới xung quanh mình. Tôi rất hào hứng được học hỏi và phát triển thông qua các cơ hội cố vấn phù hợp với giá trị và nguyện vọng của tôi.',
 '2003-02-21', '0123456789', N'Male',
 N'Degree in environmental science, skilled in data collection, analysis, and reporting.', '2024-01-18', N'Hải Dương');

GO


CREATE TABLE mentor
(
    idMentor INT
        REFERENCES dbo.account (idAccount) PRIMARY KEY,
    fullname NVARCHAR(255),
    avatar VARCHAR(MAX),
    phone VARCHAR(10),
    dob DATE,
    sex NVARCHAR(6)
        DEFAULT 'Male',
    [address] NVARCHAR(MAX),
    registerDate DATE,
    profession NVARCHAR(MAX),
    pro_introduc NVARCHAR(MAX),
    archivement_descition NVARCHAR(MAX),
    framework VARCHAR(255),
    experience NVARCHAR(MAX),
    education NVARCHAR(MAX),
    myservice NVARCHAR(MAX),
    stk NVARCHAR(255),
    cost INT
);
GO

INSERT INTO dbo.mentor
(
    idMentor,
    fullname,
    avatar,
    phone,
    dob,
    sex,
    address,
    registerDate,
    profession,
    pro_introduc,
    archivement_descition,
    framework,
    experience,
    education,
    myservice,
    stk,
    cost
)
VALUES
(1, N'Vũ Tuấn Hải', 'img/men1.jpg', '0987654321', '2003-01-01', 'Male', N'Ninh Bình', '2024-01-01',
 N'giảng viên',
 N'Tôi là một giảng viên có kinh nghiệm trong lĩnh vực lập trình. Tôi đam mê chia sẻ kiến thức và hỗ trợ sinh viên trong quá trình học tập.',
 N'Trong suốt thời gian làm việc, tôi đã đạt được nhiều thành tích, đặc biệt là trong việc hướng dẫn các dự án lập trình phức tạp.',
 N'ASP.NET, Angular', N'5 năm làm việc tại công ty ABC, 3 năm giảng dạy tại trường XYZ',
 N'Bằng cử nhân Công nghệ thông tin', N'Dịch vụ hỗ trợ lập trình web và mobile', '0123456789', 100000),
(2, N'Trịnh Quốc Toản', 'img/men2.jpg', '0987654321', '2003-01-01', 'Male', N'Nghệ An', '2024-01-01', N'giảng viên',
 N'Tôi là một chuyên gia lập trình với nhiều năm kinh nghiệm. Tôi tin rằng kiến thức của tôi sẽ giúp ích cho các bạn sinh viên.',
 N'Tôi đã từng tham gia vào nhiều dự án lớn và có nhiều đóng góp đáng kể.', N'Java, Spring Boot',
 N'7 năm làm việc tại công ty XYZ', N'Bằng thạc sĩ Khoa học máy tính', N'Dịch vụ tư vấn và phát triển ứng dụng Java',
 '0987654321', 150000),
(3, N'Vũ Văn Phát', 'img/men3.jpg', '0987654321', '2003-08-13', 'Male', N'Hải Dương', '2024-01-01', N'giảng viên',
 N'Với kinh nghiệm dạy và thực hành lập trình, tôi sẽ giúp bạn hiểu sâu hơn về các ngôn ngữ và công nghệ lập trình hiện đại.',
 N'Tôi đã có nhiều thành tích trong việc đào tạo và phát triển các dự án phần mềm.', N'Cinder, Spring, Unity, Redux',
 N'10 năm làm việc tại công ty DEF', N'Bằng tiến sĩ Công nghệ thông tin', N'Dịch vụ phát triển ứng dụng web và mobile',
 '9876543210', 200000),
(4, N'Đặng Vũ Minh', 'img/men4.jpg', '0987654321', '2003-01-01', 'Male', N'Ninh Bình', '2024-01-01',
 N'giảng viên',
 N'Tôi là một giảng viên nhiệt huyết và có niềm đam mê với lập trình. Tôi mong muốn chia sẻ kiến thức và kinh nghiệm của mình cho các bạn sinh viên.',
 N'Trong sự nghiệp làm việc, tôi đã thực hiện nhiều dự án thành công và đạt được nhiều thành tích cá nhân.',
 N'Python, Django', N'8 năm làm việc tại công ty GHI', N'Bằng kỹ sư Công nghệ thông tin',
 N'Dịch vụ phát triển ứng dụng Python', '1234567890', 200000),
(5, N'Lại Vũ Hoàng Anh', 'img/men5.jpg', '0987654321', '2003-01-01', 'Male', N'Nghệ An', '2024-01-01', N'giảng viên',
 N'Tôi là một giảng viên có tinh thần trách nhiệm cao và luôn sẵn lòng hỗ trợ sinh viên trong quá trình học tập và nghiên cứu.',
 N'Tôi đã có nhiều đóng góp quan trọng trong việc phát triển các dự án phần mềm.', N'Vue.js, Laravel',
 N'6 năm làm việc tại công ty JKL', N'Bằng kỹ sư Công nghệ thông tin', N'Dịch vụ phát triển ứng dụng web Vue.js',
 '2345678901', 110000),
(6, N'Nguyễn Tùng Sơn', 'img/men6.jpg', '0987654321', '2003-01-01', 'Male', N'Hải Dương', '2024-01-01', N'giảng viên',
 N'Với kiến thức và kinh nghiệm của mình, tôi sẽ giúp bạn hiểu rõ hơn về lập trình và phát triển các ứng dụng.',
 N'Tôi đã có nhiều thành tích trong việc hướng dẫn và phát triển các dự án phần mềm.', N'Angular, MongoDB',
 N'9 năm làm việc tại công ty MNO', N'Bằng cử nhân Công nghệ thông tin', N'Dịch vụ phát triển ứng dụng web và mobile',
 '3456789012', 150000);

GO

CREATE TABLE cv
(
    idMentor INT REFERENCES dbo.account (idAccount) PRIMARY KEY,
    fullname NVARCHAR(255),
    avatar VARCHAR(MAX),
    phone VARCHAR(10),
    dob DATE,
    sex NVARCHAR(6)
        DEFAULT 'Male',
    [address] NVARCHAR(MAX),
    registerDate DATE,
    profession NVARCHAR(MAX),
    pro_introduc NVARCHAR(MAX),
    archivement_descition NVARCHAR(MAX),
    framework VARCHAR(255),
    experience VARCHAR(MAX),
    education NVARCHAR(MAX),
    myservice NVARCHAR(MAX),
    stk NVARCHAR(255),
    cost INT,
    skill NVARCHAR(255)
);
GO

INSERT INTO dbo.cv
(
    idMentor,
    fullname,
    avatar,
    phone,
    dob,
    sex,
    address,
    registerDate,
    profession,
    pro_introduc,
    archivement_descition,
    cost,
    skill
)
VALUES
(1, N'Đinh Huy ', 'img/mentor2.jpg', '0987654321', '2003-01-01', 'Male', N'Ninh h', '2024-01-01', 'test', 'test', 'test',
 10 , '[C++, C#, Java]'),
(2, N'Nguyễn Nhật ', 'img/mentor2.jpg', '0987654321', '2003-01-01', 'Male', N'Nghn', '2024-01-01', NULL, NULL, NULL,
 11, '[C++, React, Python]'),
(3, N'Trần Thế ', 'img/mentor2.jpg', '0987654321', '2003-01-01', 'Male', N'Hảing', '2024-01-01', NULL, NULL, NULL, 12,
 '[React, Java]');
GO
CREATE TABLE skill
(
    id INT IDENTITY(1, 1) PRIMARY KEY,
    title NVARCHAR(MAX),
    image VARCHAR(MAX),
    skillName NVARCHAR(MAX),
    skill_description NVARCHAR(MAX),
    status VARCHAR(MAX)
        DEFAULT 'enable',
    fav INT
);
GO

INSERT INTO dbo.skill
(
    title,
    image,
    skillName,
    skill_description,
    fav
)
VALUES
(N'Ngôn ngữ lập trình', 'img/c++.png', N'C++', N'Học C++ cùng giảng viên', 0),
(N'Ngôn ngữ lập trình', 'img/java.png', N'Java', N'Học Java cùng giảng viên', 0),
(N'Ngôn ngữ lập trình', 'img/cSharf.png', N'C#', N'Học C# cùng giảng viên', 0),
(N'Ngôn ngữ lập trình', 'img/python.png', N'Python', N'Học Python cùng giảng viên', 0),
(N'Framework', 'img/nodejs.png', N'NodeJS', N'Học NodeJS cùng giảng viên', 0),
(N'Framework', 'img/react.png', N'React', N'Học React cùng giảng viên', 0);
GO

CREATE TABLE have_skill
(
    idMentor INT
        REFERENCES dbo.mentor (idMentor),
    idSkill INT
        REFERENCES dbo.skill (id),
    PRIMARY KEY (
                    idMentor,
                    idSkill
                ),
);
GO

INSERT INTO dbo.have_skill
(
    idMentor,
    idSkill
)
VALUES
(1, 1),
(2, 4),
(3, 3),
(3, 1),
(3, 2),
(3, 5),
(4, 6),
(5, 4),
(6, 3),
(4, 1),
(2, 2),
(5, 3),
(3, 6),
(1, 4),
(6, 5);
GO




CREATE TABLE news
(
    newsID INT IDENTITY(1, 1) PRIMARY KEY,
    title NVARCHAR(MAX),
    content NVARCHAR(MAX),
    imageURL VARCHAR(MAX),
    postDate DATE,
    eventDay INT,
    eventMonth NVARCHAR(MAX),
    eventYear INT,
    summary NVARCHAR(MAX)
);
GO
-- Insert sample data
INSERT INTO news
(
    title,
    content,
    imageURL,
    postDate,
    eventDay,
    eventMonth,
    eventYear,
    summary
)
VALUES
('HAPPY STUDENT',
 'Happy schools is a special extension of the book Happy Children (same author). Through this book, Dr. Ha Vinh Tho and his team hope to bring to parents, teachers and political planners educational books and educational research options within the framework of the Happy Schools Project, providing those who care about the well-being of children and young people with much-needed encouragement. essential in efforts to improve global education systems and provide useful, applicable guidance in schools.

"Happy schools" by Professor Ha Vinh Tho outlines the "outlines" of a happy school, starting with relationships in the school community and the positive attitude of teachers, improving working conditions. work for teachers, equipping them with practices and skills that help teachers feel well-being, and then creating a safe, friendly, warm learning environment that nurtures well-being, resilience, and curiosity. in students.
The book helps teachers see clearly through the educational structures and regulations that have dominated our minds, and helps us discover the core of improving the quality of education, which is:
The ability to listen and visualize, open perspectives and co-create the definition of success and how we perceive it;
The ability to learn and design, bring curiosity and critical thinking, value learner autonomy and aim for high thinking capacity;
Oriented to nurturing love and connection, building relationships, nurturing a sense of belonging, cultivating culture and humanity;
The willingness to reflect and learn, to put down what is known and learn something new at all levels of the education system.
With the message from the book Happy School - Teachers are parents, school is home, we hope that every day going to school will be a completely happy day for students.',
 'img/event-1.jpg', '2024-02-26', '01', 'April', '2024', 'Details about the new product launch.'),
('HOME COMING',
 'Three amazing things that inner child healing work brings about: the speed with which people change; degree of change; the strength and creativity they have when past wounds are healed,” Bradshaw shared.
First, we see the world through the eyes of a small child, and that child remains inside us throughout our lives, no matter how mature and strong we become. If our vulnerable child is hurt, abandoned, shamed, or ignored, his or her pain, sadness, and anger will live on inside of us forever. “I believe that the abandonment and trauma of the inner child is the source of human misery,” he said.
Do you long to be a loving parent but often fail and hurt your children? Do you crave intimacy but wonder if its worth the fight? Do you sometimes lose energy because of anxiety or depression? At that point, returning home to your true self might be helpful.
In this life-changing book, Homecoming: Reviving Your Inner Child, John Bradshawn shows us how to nurture our needy inner child, essentially providing giving us the best parenting we need and crave.
Through a step-by-step process of exploring each stage of our childhood development, we can break free from the family rules that hurt us and free ourselves to live responsibly in our childhood. current point.
The book offers countless case studies, interactive techniques, including quizzes, handwritten letters, guided meditations, sadness, and affirmations. Considered a pioneer when introduced, these classic therapies are being validated by new discoveries in attachment research and neuroscience. No one has brought them to a mass audience as effectively and inspirationally as John Bradshaw.
His therapies are being used around the world and attended by millions of people.
The book is recommended for academic, professional, private, and public libraries and those looking for ways to truly become the kind of person they want people to think they are.',
 'img/event-2.jpg', '2024-02-25', '10', 'April', '2024', 'Information about the company expansion.'),
('HAPPY TEACHER HAPPY STUDENT',
 'According to Prof Dr Rika Hosotani and Prof Dr Kyoko Imai-Matsumura from Hyogo University of Teacher Education in Japan, the quality of teachers’ emotional approach towards children can greatly influence their learning.
One must never neglect the students’ feelings during lessons, either physically or online, but educators must also pay attention to their own emotions.
Educators must have adequate time to achieve balance in their lives, including managing their workload, setting time aside to evaluate students’ progress in academics and behaviour, and developing stress-tolerance and supportive management. Happy educators lead to happy students.
The dependency on electronic gadgets and the advances of AI and AR/VR learning through gamification have impacted interactions between students and educators.
Thanks to technology, students can learn from wherever they are but the psychological aspects of human interaction must never be neglected.
Addressing mental health issues before the problem worsens is important. While the importance of mental health is recognised, some students may be too shy to seek help or do not know where to do so.
Educators and counsellors must be approachable and accessible to their students because a strong human connection can lead to a happier and stress-free life.',
 'img/event-3.jpg', '2024-02-24', '15', 'April', '2024', 'Details about the upcoming event.');
GO

CREATE TABLE pay
(
    qr VARCHAR(255)
);
INSERT INTO dbo.pay
(
    qr
)
VALUES
('qr.jsp');

CREATE TABLE blog
(
    idblog INT IDENTITY(1, 1) PRIMARY KEY,
    idMentor INT
        REFERENCES dbo.mentor (idMentor),
    updatedate VARCHAR(20),
    thumbnail VARCHAR(MAX),
    title NVARCHAR(MAX),
    briefinfo NVARCHAR(MAX),
    detailinfo NVARCHAR(MAX),
    id INT
        REFERENCES skill (id),
    isAgree INT
);

INSERT INTO blog
(
    idMentor,
    updatedate,
    thumbnail,
    title,
    briefinfo,
    detailinfo,
    id,
    isAgree
)
VALUES
(1, '2024-03-09', 'thumbnail_image_url.jpg', 'Title of the Blog Post', 'Brief information about the blog post.',
 'Detailed information about the blog post.', 1, 1),
(2, '2024-03-08', 'another_thumbnail_image_url.jpg', 'Another Blog Post', 'Brief information about another blog post.',
 'Detailed information about another blog post.', 2, 1),
(3, '2024-03-07', 'third_thumbnail_image_url.jpg', 'Yet Another Blog Post',
 'Brief information about yet another blog post.', 'Detailed information about yet another blog post.', 3, 1),
(4, '2024-03-09', 'new_thumbnail_image_url.jpg', 'New Blog Post', 'Brief information about the new blog post.',
 'Detailed information about the new blog post.', 4, 1),
(5, '2024-1-10', 'img/thumb4.png', 'Lorem ipsum, dolor sit amet consectetur adipisicing 4',
 'Lorem ipsum dolor, sit amet consectetur adipisicing elit. Omnis libero quas ipsum laudantium nihil! Quaerat 4.',
 'Lorem ipsum dolor, sit amet consectetur adipisicing elit. Omnis libero quas ipsum laudantium nihil! Quaerat DetailInfo 4.',
 4, 1),
(6, '2024-2-02', 'img/thumb5.png', 'Lorem ipsum, dolor sit amet consectetur adipisicing 5',
 'Lorem ipsum dolor, sit amet consectetur adipisicing elit. Omnis libero quas ipsum laudantium nihil! Quaerat 5.',
 'Lorem ipsum dolor, sit amet consectetur adipisicing elit. Omnis libero quas ipsum laudantium nihil! Quaerat DetailInfo 5.',
 3, 1),
(1, '2024-2-14', 'img/thumb6.png', 'Lorem ipsum, dolor sit amet consectetur adipisicing 6',
 'Lorem ipsum dolor, sit amet consectetur adipisicing elit. Omnis libero quas ipsum laudantium nihil! Quaerat 6.',
 'Lorem ipsum dolor, sit amet consectetur adipisicing elit. Omnis libero quas ipsum laudantium nihil! Quaerat DetailInfo 6.',
 5, 1),
(1, '2024-1-08', 'img/thumb7.png', 'Lorem ipsum, dolor sit amet consectetur adipisicing 7',
 'Lorem ipsum dolor, sit amet consectetur adipisicing elit. Omnis libero quas ipsum laudantium nihil! Quaerat 7.',
 'Lorem ipsum dolor, sit amet consectetur adipisicing elit. Omnis libero quas ipsum laudantium nihil! Quaerat DetailInfo 7.',
 6, 1);

 CREATE TABLE wallet(
	idAccount INT REFERENCES dbo.account(idAccount),
	amount INT,
	hold INT
 )
GO

INSERT INTO dbo.wallet
(
    idAccount,
    amount,
	hold
)
VALUES (1,0,0),
(2,100000,0),
(3,0,0),
(4,0,0),
(5,0,0),
(6,0,0),(7,0,0),(8,0,0),(9,0,0),(10,0,0),(11,0,0),(12,0,0),(14,0,0)
GO

CREATE TABLE historyWallet(
	id INT IDENTITY(1,1) PRIMARY KEY,
	idAccount INT REFERENCES dbo.account(idAccount),
	nameMentee NVARCHAR(255),
	amount INT,
	datePay DATETIME,
	content NVARCHAR(255),
	stype NVARCHAR(10)
)
GO

-- nhận tiền là deposit, trừ tiền là payment

CREATE TABLE requestTakeMoney(
	id INT IDENTITY(1,1) PRIMARY KEY,
	fullname NVARCHAR(max),
	username NVARCHAR(max),
	money INT
)
GO
CREATE TABLE time_slot(
	time_slot_id int primary key,
	time nvarchar(20),
)
GO

INSERT INTO  time_slot
VALUES (1, '7:30 - 9:50'),
	   (2, '10:00 - 12:20'),
	   (3, '12:50 - 15:10'),
	   (4, '15:20 - 17:40'),
	   (5, '18:00 - 20:20'),
	   (6, '20:30 - 22:50')
GO

CREATE TABLE timeSchedule (
    timeScheduleId INT IDENTITY(1,1) PRIMARY KEY,
    year INT,
    week INT,
    day VARCHAR(20),
	slotId INT FOREIGN KEY REFERENCES time_slot(time_slot_id)
);
GO
INSERT INTO timeSchedule(year, week, day, slotId) VALUES
(2024, 12, 'mon', 1),
(2024, 12, 'tue', 2),
(2024, 12, 'wed', 3),
(2024, 12, 'thu', 4),
(2024, 12, 'fri', 5),
(2024, 12, 'sat', 6),
(2024, 13, 'mon', 1),
(2024, 13, 'tue', 2),
(2024, 13, 'wed', 3),
(2024, 13, 'thu', 4),
(2024, 13, 'fri', 5),
(2024, 13, 'sat', 6),
(2024, 14, 'mon', 1),
(2024, 14, 'tue', 2),
(2024, 14, 'wed', 3),
(2024, 14, 'thu', 4),
(2024, 14, 'fri', 5),
(2024, 14, 'sat', 6),
(2024, 15, 'mon', 1),
(2024, 15, 'tue', 2),
(2024, 15, 'wed', 3),
(2024, 15, 'thu', 4),
(2024, 15, 'fri', 5),
(2024, 15, 'sat', 6),
(2024, 16, 'mon', 1),
(2024, 16, 'tue', 2),
(2024, 16, 'wed', 3),
(2024, 16, 'thu', 4),
(2024, 16, 'fri', 5),
(2024, 16, 'sat', 6),
(2024, 17, 'mon', 1),
(2024, 17, 'tue', 2),
(2024, 17, 'wed', 3),
(2024, 17, 'thu', 4),
(2024, 17, 'fri', 5),
(2024, 17, 'sat', 6)
GO


CREATE TABLE scheduleRequest(
	mentor_id int foreign key references mentor(idMentor),
	timeScheduleId INT FOREIGN KEY REFERENCES  timeSchedule(timeScheduleId),
	status int not null FOREIGN KEY REFERENCES status(status_id)
)
GO
INSERT INTO scheduleRequest(mentor_id, timeScheduleId, status) VALUES 
(1, 1, 2),
(1, 2, 2),
(1, 3, 2),
(1, 4, 2),
(1, 5, 2),
(1, 6, 2),
(1, 7, 2),
(1, 8, 2),
(1, 9, 2),
(1, 10, 2),
(1, 11, 2),
(1, 12, 2),
(1, 13, 2),
(1, 14, 2),
(1, 15, 2),
(1, 16, 2),
(1, 17, 2),
(1, 18, 2),
(1, 19, 2),
(1, 20, 2),
(1, 21, 2),
(1, 22, 2),
(1, 23, 2),
(1, 24, 2),
(1, 25, 2),
(1, 26, 2),
(1, 27, 2),
(1, 28, 2),
(1, 29, 2),
(1, 30, 2),
(1, 31, 2),
(1, 32, 2),
(1, 33, 2),
(1, 34, 2),
(1, 35, 2),
(1, 36, 2)
GO


CREATE TABLE mentorSchedule (
    idMentor INT FOREIGN KEY REFERENCES mentor(idMentor),
    timeScheduleId INT FOREIGN KEY REFERENCES timeSchedule(timeScheduleId),
)
GO

CREATE TABLE menteeSchedule (
    menteeSchedule_id INT IDENTITY(1,1) PRIMARY KEY,
    idMentee INT FOREIGN KEY REFERENCES mentee(idMentee),
    timeScheduleId INT FOREIGN KEY REFERENCES timeSchedule(timeScheduleId),
	skill_id int foreign key references skill(id)
)
GO


GO

CREATE TABLE request
(
    idRequest INT IDENTITY(1, 1) PRIMARY KEY,
    idMentee INT REFERENCES dbo.mentee (idMentee),
    idMentor INT REFERENCES dbo.mentor (idMentor),
    title NVARCHAR(MAX),
    content NVARCHAR(MAX),
    skillId INT REFERENCES dbo.skill(id),
    statusId INT REFERENCES dbo.[status](status_id),
	timeScheduleId INT FOREIGN KEY REFERENCES  timeSchedule(timeScheduleId),
    startWeek VARCHAR(255),
    endWeek VARCHAR(MAX),
    hour FLOAT,
    reasonReject NVARCHAR(MAX),
    totalCost INT
);
GO
INSERT INTO request(idMentee, idMentor, title, content, skillId, statusId, timeScheduleId, startWeek, endWeek, hour, reasonReject, totalCost) VALUES 
(7, 1, 'Gia su','Pass C++', 1, 1 , 1 , 12 , 17 , 1 , null, 100000),
(7, 1, 'Gia su','Pass C++', 1, 1 , 2 , 12 , 17 , 1 , null, 100000),
(8, 1, 'Gia su','Pass C++', 1, 1 , 1 , 12 , 17 , 1 , null, 100000),
(8, 1, 'Gia su','Pass C++', 1, 1 , 2 , 12 , 17 , 1 , null, 100000),
(9, 1, 'Gia su','Pass C++', 1, 1 , 1 , 13 , 15 , 1 , null, 100000),
(9, 1, 'Gia su','Pass C++', 1, 1 , 2 , 13 , 15 , 1 , null, 100000),
(10, 1, 'Gia su','Pass C++', 1, 1 , 3 , 12 , 17 , 1 , null, 100000),
(10, 1, 'Gia su','Pass C++', 1, 1 , 4 , 12 , 17 , 1 , null, 100000),
(11, 1, 'Gia su','Pass C++', 1, 1 , 5 , 12 , 17 , 1 , null, 100000),
(11, 1, 'Gia su','Pass C++', 1, 1 , 6 , 12 , 17 , 1 , null, 100000),
(12, 1, 'Gia su','Pass C++', 1, 1 , 7 , 13 , 15 , 1 , null, 100000),
(12, 1, 'Gia su','Pass C++', 1, 1 , 8 , 13 , 15 , 1 , null, 100000)
GO

CREATE TABLE rate
(
    idRate INT IDENTITY(1, 1) PRIMARY KEY,
    idRequest INT
        REFERENCES dbo.request (idRequest),
    idMentee INT
        REFERENCES dbo.mentee (idMentee),
    idMentor INT
        REFERENCES dbo.mentor (idMentor),
    star INT,
    comment NVARCHAR(MAX),
    time DATETIME NOT NULL
);
GO
CREATE TABLE reportReq
(
    idRequest INT
        REFERENCES dbo.request (idRequest),
    title NVARCHAR(MAX),
    content NVARCHAR(MAX),
);
CREATE TABLE reasonRejectSchedule
(
	idRequest INT IDENTITY(1,1) PRIMARY KEY,
    idMentor INT
        REFERENCES dbo.mentor (idMentor),
    note NVARCHAR(MAX),
    time datetime,
	status int,
);

CREATE TABLE updateScheduleRequest(
	mentor_id int foreign key references mentor(idMentor),
	status int not null FOREIGN KEY REFERENCES status(status_id),
	reasonReject nvarchar(255)
)

UPDATE [swp].[dbo].[skill]
SET skill_description = N'Khóa học React từ cơ bản đến nâng cao, giúp bạn làm các dự án phổ biến. Kết thúc khóa, bạn sẽ hoàn thành một dự án giống Tiktok.com và tự tin xin việc với kiến thức đã học.'
WHERE id = 6;

UPDATE [swp].[dbo].[skill]
SET skill_description = N'Khóa học C# từ cơ bản đến nâng cao cho người mới, giúp nắm vững các khái niệm lập trình và tạo nền tảng vững chắc để trở thành lập trình viên.'
WHERE id = 3;

UPDATE [swp].[dbo].[skill]
SET skill_description = N'Khóa học Node từ trung cấp, Học Back-end với Node & ExpressJS framework, hiểu các khái niệm khi làm Back-end và xây dựng RESTful API cho trang web.'
WHERE id = 5;

UPDATE [swp].[dbo].[skill]
SET skill_description = N'Khóa học Python từ cơ bản đến nâng cao cho người mới, giúp nắm vững các khái niệm lập trình và tạo nền tảng vững chắc để trở thành lập trình viên.'
WHERE id = 4;


UPDATE [swp].[dbo].[skill]
SET skill_description = N'Khóa học Java được xây dựng theo lộ trình bài bản, từ JAVA CƠ BẢN đến JAVA WEB và nâng cao về JAVA FRAMEWORK như: Spring Boot, Hibernate'
WHERE id = 2;

UPDATE [swp].[dbo].[skill]
SET skill_description = N'Khóa học C++ từ cơ bản đến nâng cao cho người mới, giúp nắm vững các khái niệm lập trình và tạo nền tảng vững chắc để trở thành lập trình viên.'
WHERE id = 1;