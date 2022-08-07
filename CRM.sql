drop schema if exists crmproject cascade;
create schema crmproject;
set search_path to crmproject;

drop table if exists role;
create table role
(
    role_id     integer generated always as identity primary key,
    rolename    varchar(50)                         not null,--Admin (Superuser), User
    perms       varchar(260)                        not null,
    last_update timestamp default CURRENT_TIMESTAMP not null,
    check ( length(rolename) >= 3 )
);

insert into role (rolename, perms)
values ('Administrator', 'Access to control panel, create ,delete,view, configure, and manage all projects'),
       ('User', 'Can:Create and delete data sets and projects;Transform data within a project;' ||
                'View, configure, and manage projects for which they have a project role; Edit their account information. ' ||
                'Cannot:Access the Control Panel'),
       ('User', 'Can:Create and delete data sets and projects;Transform data within a project;' ||
                'View, configure, and manage projects for which they have a project role; Edit their account information. ' ||
                'Cannot:Access the Control Panel'),
       ('User', 'Can:Create and delete data sets and projects;Transform data within a project;' ||
                'View, configure, and manage projects for which they have a project role; Edit their account information. ' ||
                'Cannot:Access the Control Panel');

drop table if exists tbuser;
create table tbuser
(
    user_id     integer generated always as identity primary key,
    username    varchar(50) unique not null,
    password    varchar(50)        not null,
    firstName   varchar(50)        not null,
    lastName    varchar(50)        not null,
    email       text               not null,
    last_update timestamp default CURRENT_TIMESTAMP,
    role_id     integer references "role" (role_id),
    check ( length(email) >= 6 and email ilike '%@%.%' )
);

insert into tbuser (username, password, firstName, lastName, email)
values ('John', '251gqe', 'Ada', 'Smith', 'john@example.com'),
       ('Jane', '75giodgqe$', 'Ron', 'Chen', 'jane@example.com'),
       ('Joe', '0gidg#qe$', 'Adam', 'Emile', 'joe@example.com'),
       ('Ane', 'GKgiodgqe#', 'Joseph', 'Bird', 'jane@example.com');



drop table if exists client;
create table client

(
    client_id     integer generated always as identity primary key,
    status        smallint                            not null,--0: Inactive, 1: Prospect, 2: Active)
    firstName     varchar(50)                         not null,
    lastName      varchar(50)                         not null,
    dateOfBirth   date                                not null,
    age           smallint                            not null,
    homePhone     VARCHAR(50),
    cellPhone     VARCHAR(50),
    email         text,
    address       VARCHAR(100)                        not null,
    postalCode    VARCHAR(7)
                                                      not null,
    SIN           VARCHAR(9),
    gender        VARCHAR(50)
                                                      not null,
    maritalStatus VARCHAR(20)
                                                      not null,
    citizenship   VARCHAR(50)
                                                      not null,
    source        VARCHAR(50)
                                                      not null,
    referredBy    VARCHAR(50)
                                                      not null,
    giftGiven     boolean                             not null,
    planID        VARCHAR(50),
    segFundNum    VARCHAR(50),
    weChatID      VARCHAR(50),
    linkedInID    VARCHAR(50),
    facebookID    VARCHAR(50),
    twitterID     VARCHAR(50),
    instagramID   VARCHAR(50),
    last_update   timestamp default CURRENT_TIMESTAMP not null,
    check ( length(email) >= 6 and email ilike '%@%.%'
        )

);

insert into client (status, firstName, lastName, dateOfBirth, age, homePhone, cellPhone, email, address,
                    postalCode, SIN, gender, maritalStatus, citizenship, source, referredBy, giftGiven, planID,
                    segFundNum, weChatID, linkedInID, facebookID, twitterID, instagramID)
values (0, 'Alice', 'Tyler', '1990-08-31', '32', '514-784-6899',
        '514-784-6807', 'gjak@gmail.com', '57 st laurant st', 'h7g 2g1', '784858121'
           , 'female', 'single', 'Canadian', 'friend', 'Angela Wang', 'true',
        '938545', '4986GK', 'GJAIER', 'GAGJ', 'GKJSA', 'GKAS', 'IUE'),
       (1, 'George', 'Beaconsfield', '1980-08-31', '42', '708-784-6899',
        '708-784-6807', 'ggsagk@gmail.com', '100 st denis st', 'y7h 1g1', '592858121'
           , 'male', 'married', 'Others', 'family', 'Ben Space', 'false',
        '9gga545', 'gag6GK', 'gasidIER', '39imfJ', 'Gah9eA', '34iopgmS', 'bhsa'),
       (0, 'Kim', 'Gus', '1970-08-31', '52', '900-784-6899',
        '900-784-6807', 'gai1sagk@gmail.com', '10 st denis st', 'u7h 1g1', '892858121'
           , 'male', 'divorced', 'Others', 'social media', 'Medi Cute', 'false',
        'hgl9gga545', '2lgag6GK', 'ghoagasidIER', '39k39imfJ', '3r98Gah9eA', 'gagopgmS', 'gagsa'),
       (3, 'Jackie', 'She', '1960-08-31', '62', '880-784-6899',
        '880-784-6807', 'aweeai1sagk@gmail.com', '10 st antoine st', 'g8h 1g1', '362858121'
           , 'female', 'common law', 'Others', 'client', 'Ana Cote', 'true',
        'gahgl9gga545', 'gaklgag6GK', '3ghoagasidIER', '2kf39k39imfJ', '3ij3r98Gah9eA', 'a9gagopgmS', '2dgagsa'),
       (3, 'Shel', 'Bonjour', '1950-08-31', '72', '378-784-6899',
        '378-784-6807', 'aweeadasi1sagk@gmail.com', '101 st antoine st', 'g8h 1g1', '161858121'
           , 'female', 'separated', 'Others', 'Others', 'Jean Cat', 'true',
        'g1gahgl9gga545', '1ggaklgag6GK', '1g3ghoagasidIER', '9232kf39k39imfJ', '43ij3r98Gah9eA', '4a9gagopgmS', '4' ||
                                                                                                                 '2dgagsa');
drop table if exists toDoList;
create table toDoList
(
    toDoId      integer generated always as identity primary key,
    title       varchar(50)                         not null,
    description varchar(2500),
    priority    smallint                            not null,
    dueDate     date,
    completion  boolean                             not null,
    location    varchar(100)                        not null,
    note        varchar(50),
    last_update timestamp default CURRENT_TIMESTAMP not null,
    client_id   integer references client


);
insert into toDoList (title, description, priority, dueDate, completion, location)
values ('Appointment with Jenny ', 'discuss about the new tax saving plan tfsa', 1, '2022-08-31', true,
        '101 st faucon'),
       ('Call Nina ', 'discuss about resp', 2, '2022-08-31', false, '101 st sauver'),
       ('Play tennis with Anne ', 'discuss about tax planning', 3, '2022-12-31', false, '101 st denis'),
       ('Appointment with Ron ', 'discuss about the travel insurance', 4, '2023-08-31', true, '101 st laurent');

drop table if exists Insurance;
create table Insurance
(
    insuranceID          integer generated always as identity primary key,
    productCode          varchar(50) unique                  not null,
    policyNumber         varchar(50) unique,
    applicationNumber    varchar(50) unique,
    applicationDate       date,
    COI                  decimal(13, 2),
    enforcementDate      DATE,
    maturityDate        DATE,
    coverageAmount      decimal(13, 2),
    additionalDeposit      decimal(13, 2),
    PaymentTime      SMALLINT,
    riders varchar(50) ,
    province             varchar(50),
    Note                 varchar(50),
    last_update          timestamp default CURRENT_TIMESTAMP not null

);
insert into Insurance (ProductCode, policyNumber,applicationNumber,applicationDate,COI,enforcementDate, maturityDate ,coverageAmount,additionalDeposit  , PaymentTime ,  riders)
values ('mica','A8785','E985353','2022-08-06', 5000.23,'2022-09-01','2032-09-01',500000.00, 280.90,10,'CPR'),
       ('gica','B8785','E8545353','2022-09-06', 6000.23,'2022-10-01','2032-10-01',600000.00, 300.90,10,'GIO'),
       ('termca','A7785','E985853','2022-08-06', 7000.23,'2022-11-01','2032-11-01',700000.00, 280.90,10,'CPR'),
       (' di65ca','A4576','E14311','2022-01-06', 8000.23,'2022-12-01','2032-12-01',800000.00, 280.90,10,'TDW');

drop table if exists Product;
create table Product
(
    ProductID   integer generated always as identity primary key,
    ProductCode varchar(50)                         not null,
    InsuranceID integer references Insurance,
    last_update timestamp default CURRENT_TIMESTAMP not null
);
insert into Product (ProductCode)
values ('parca'),
       ('termca'),
       ('termca'),
       (' di65ca');

drop table if exists ClientProduct;
create table ClientProduct
(
    client_id
                integer references client
                                                    not null,
    productID
                integer references product
                                                    not null,
    primary key (client_id, ProductID),
--     policyNumber  VARCHAR(50),
--     startDate   date,
--     endDate     date,
-- --     coverage    decimal(13, 2),
    last_update timestamp default CURRENT_TIMESTAMP not null
);
-- insert into ClientProduct (startDate, endDate, coverage)
-- values ('2022-05-30', '2022-10-31', 500000.76),
--        ('2022-01-30', '2022-08-31', 1000000.56),
--        ('2022-01-01', '2022-10-31', 1500000.56),
--        ('2022-03-30', '2022-12-31', 700000.34);
-- SELECT * FROM client WHERE firstName IS IN ();
-- SELECT * FROM client WHERE lastName IS IN ();
SELECT C.CLIENT_ID, PRIORITY ,DUEDATE,P.PRODUCTCODE,firstName,lastName
    FROM  CLIENT C
    INNER JOIN TODOLIST T ON C.CLIENT_ID = T.client_id
    INNER JOIN CLIENTPRODUCT CP ON CP.CLIENT_ID=C.client_id
        INNER JOIN PRODUCT P ON P.PRODUCTID=CP.productID
        INNER JOIN INSURANCE I ON I.INSURANCEID=P.InsuranceID
WHERE LASTNAME = ('TYLER')
ORDER BY DUEDATE;

-- select instructor.iid, name
-- from offering
--          inner join instructor on offering.iid = instructor.iid
-- where semester = 'W'
--   and year = 2020;