-- drop schema if exists crmproject cascade;
-- create schema crmproject;
-- set search_path to crmproject;

drop table if exists role cascade ;
create table role
(
    role_id     integer generated always as identity primary key,
    rolename    varchar(50)                         not null,--Admin (Superuser), User
    perms       varchar(260)                        not null,
    last_update timestamp default CURRENT_TIMESTAMP,
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

drop table if exists tbuser cascade;
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

insert into tbuser (username, password, firstName, lastName, email,role_id)
values ('John', '251gqe', 'Ada', 'Smith', 'john@example.com',1),
       ('Jane', '75giodgqe$', 'Ron', 'Chen', 'jane@example.com',2),
       ('Joe', '0gidg#qe$', 'Adam', 'Emile', 'joe@example.com',3),
       ('Ane', 'GKgiodgqe#', 'Joseph', 'Bird', 'jane@example.com',4);



drop table if exists client cascade;
create table client

(
    client_id     integer generated always as identity primary key,
    status        smallint                            not null,--0: Inactive, 1: Prospect, 2: Active)
    firstName     varchar(50),
    lastName      varchar(50),
    dateOfBirth   date,
    age           smallint,
    homePhone     VARCHAR(50),
    cellPhone     VARCHAR(50),
    email         text,
    address       VARCHAR(100),
    postalCode    VARCHAR(7),

    SIN           VARCHAR(9),
    gender        VARCHAR(50),

    maritalStatus VARCHAR(20),

    citizenship   VARCHAR(50),

    source        VARCHAR(50),

    referredBy    VARCHAR(50),

    giftGiven     boolean   ,
    planID        VARCHAR(50),
    segFundNum    VARCHAR(50),
    weChatID      VARCHAR(50),
    linkedInID    VARCHAR(50),
    facebookID    VARCHAR(50),
    twitterID     VARCHAR(50),
    instagramID   VARCHAR(50),
    last_update   timestamp default CURRENT_TIMESTAMP,
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
drop table if exists toDoList cascade;
create table toDoList
(
    toDoId      integer generated always as identity primary key,
    title       varchar(50)                         not null,
    description varchar(2500),
    priority    smallint                            not null,
    dueDate     date,
    completion  boolean                             not null,
    location    varchar(100)                       ,
    note        varchar(50),
    last_update timestamp default CURRENT_TIMESTAMP,
    client_id   integer references client


);
insert into toDoList (title, description, priority, dueDate, completion, location, client_id)
values ('Appointment with Alice ', 'discuss about the new tax saving plan tfsa', 1, '2022-08-31', true,
        '101 st faucon',1),
       ('Call Nina ', 'discuss about resp', 2, '2022-08-31', false, '101 st sauver',2),
       ('Play tennis with Anne ', 'discuss about tax planning', 3, '2022-12-31', false, '101 st denis',3),
       ('Appointment with Ron ', 'discuss about the travel insurance', 4, '2023-08-31', true, '101 st laurent',4);

drop table if exists Insurance cascade;
create table Insurance
(
    insuranceID          integer generated always as identity primary key,
    policyNumber         varchar(50) unique,
    applicationNumber    varchar(50) unique,
    applicationDate       date,
    COI                  varchar(50),
    enforcementDate      DATE,
    maturityDate        DATE,
    coverageAmount      decimal(13, 2),
    additionalDeposit      decimal(13, 2),
    PaymentTime      SMALLINT,
    riders varchar(50) ,
    province             varchar(50),
    Note                 varchar(255),
    last_update          timestamp default CURRENT_TIMESTAMP

);
insert into Insurance (policyNumber,applicationNumber,applicationDate,COI,enforcementDate, maturityDate ,coverageAmount,additionalDeposit  , PaymentTime ,  riders,province)
values ('A8785','E985353','2022-08-06', 5000.23,'2022-09-01','2032-09-01',500000.00, 280.90,10,'CPR','QC'),
       ('B8785','E8545353','2022-09-06', 6000.23,'2022-10-01','2032-10-01',600000.00, 300.90,10,'GIO','ON'),
       ('A7785','E985853','2022-08-06', 7000.23,'2022-11-01','2032-11-01',700000.00, 280.90,10,'CPR','QC'),
       ('A4576','E14311','2022-01-06', 8000.23,'2022-12-01','2032-12-01',800000.00, 280.90,10,'TDW','BC');

drop table if exists Product cascade;
create table Product
(
    ProductID   integer generated always as identity primary key,
    ProductCode varchar(50)                   unique not null,
    InsuranceID integer references Insurance,
    last_update timestamp default CURRENT_TIMESTAMP
);
insert into Product (ProductCode,insuranceid)
values ('parca',1),
       ('termca',2),
       ('termca1',3),
       (' di65ca',4);

drop table if exists ClientProduct cascade;
create table ClientProduct
(
    sys_client_id
                integer references client
                                                    not null,
    sys_product_id
                integer references product
                                                    not null,
    primary key (sys_client_id, sys_product_id),
--     policyNumber  VARCHAR(50),
--     startDate   date,
--     endDate     date,
-- --     coverage    decimal(13, 2),
    last_update timestamp default CURRENT_TIMESTAMP
);
 insert into ClientProduct (sys_client_id, sys_product_id)
values (1, 2),
       (2, 1),
       (3, 4),
       (4, 3);

--count the active customer, inactive customers, prospects ,status of client (0: Inactive, 1: Prospect, 2: Active)
select status,count(status) from client
       group by status
order by status ;



SELECT * FROM client WHERE client.lastName =('Tyler');
SELECT * FROM client WHERE CLIEnT.FIRSTName = ('Alice');
select * from todolist where priority =1;

SELECT C.CLIENT_ID, PRIORITY ,DUEDATE,P.PRODUCTCODE,firstName,lastName
    FROM  CLIENT C
    INNER JOIN TODOLIST T ON C.CLIENT_ID = T.client_id
    INNER JOIN CLIENTPRODUCT CP ON CP.sys_client_id=C.client_id
        INNER JOIN pRODUCT P ON P.PRODUCTID=CP.sys_product_id
        INNER JOIN INSURANCE I ON I.INSURANCEID=P.InsuranceID
WHERE LASTNAME = ('Tyler')
ORDER BY DUEDATE;

-- search by customer last name, the insurance policy number, coverage amount, productcode, etc.
SELECT C.CLIENT_ID, P.PRODUCTCODE, i.policyNumber,i.coverageAmount,firstName,lastName
    FROM  CLIENT C
        INNER JOIN CLIENTPRODUCT CP ON CP.sys_client_id=C.client_id
        INNER JOIN pRODUCT P ON P.PRODUCTID=CP.sys_product_id
        INNER JOIN INSURANCE I ON I.INSURANCEID=P.InsuranceID
WHERE C.firstName = ('TYLER')
ORDER BY policyNumber ;

--sum of the total coi(cost of insurance) & coverage amount by each client's name
SELECT firstName,lastName,sum(i.coi) Total_CostOf_Insurance,sum(i.coverageAmount) Total_Coverage_Amount
    FROM  CLIENT C
        INNER JOIN CLIENTPRODUCT CP ON CP.sys_client_id=C.client_id
        INNER JOIN pRODUCT P ON P.PRODUCTID=CP.sys_product_id
        INNER JOIN INSURANCE I ON I.INSURANCEID=P.InsuranceID
group by c.lastName,c.firstName
ORDER BY c.lastname,c.firstName ;

--count total number of users by each role
SELECT r.role_id, count(user_id) total_Number_Of_Users
    FROM  role r
        INNER JOIN tbuser u ON r.role_id=U.role_id
        group by R.role_id
ORDER BY R.role_id ;




-- set client to inactive
-- update  client
-- set status = 0
-- where client_id = variable;

-- select instructor.iid, name
-- from offering
--          inner join instructor on offering.iid = instructor.iid
-- where semester = 'W'
--   and year = 2020;