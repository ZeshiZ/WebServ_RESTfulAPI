
use HundredAcresContact
;
go

select * 
from sys.all_objects
;
go

	
if OBJECT_ID('Contact.message', 'U') is not null
	drop table Contact.message
;
go

create table Contact.message
(
	-- column_name data_type constraint(s)
    id int identity(1, 1) not null auto_increment,
	name nvarchar(50) not null,
    email nvarchar(50) not null,
    subject nvarchar(15) not null,
    message nvarchar(200) not null,
	constraint pk_message primary key clustered (id asc)
)
;
go
