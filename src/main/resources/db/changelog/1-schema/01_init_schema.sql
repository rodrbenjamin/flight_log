-- this file is generated from JPA
create sequence seq_flight start with 100 increment by 50;
create sequence seq_person start with 100 increment by 50;
create table c_airplane_type (max_capacity integer not null, id bigint not null, type varchar(255) unique, primary key (id));
create table c_club_airplane (archived boolean not null, id bigint not null, type_id bigint, immatriculation varchar(255) unique, primary key (id));
create table t_flight (club_airplane_id bigint, copilot_person_id bigint, glider_flight_id bigint unique, id bigint not null, landing_time timestamp(6), pilot_person_id bigint, takeoff_time timestamp(6), towplane_flight_id bigint unique, flight_type varchar(255) not null check (flight_type in ('TOWPLANE','GLIDER')), guest_airplane_immatriculation varchar(255), guest_airplane_type varchar(255), note varchar(255), task varchar(255), primary key (id));
create table t_person (id bigint not null, member_id bigint, city varchar(255), country varchar(255), first_name varchar(255), last_name varchar(255), person_type varchar(255) not null check (person_type in ('CLUB_MEMBER','GUEST')), postal_code varchar(255), street varchar(255), primary key (id));
alter table if exists c_club_airplane add constraint FK_club_airplane_type foreign key (type_id) references c_airplane_type;
alter table if exists t_flight add constraint FK_club_airplane_id foreign key (club_airplane_id) references c_club_airplane;
alter table if exists t_flight add constraint FK_pilot_person_id foreign key (pilot_person_id) references t_person;
alter table if exists t_flight add constraint FK_copilot_person_id foreign key (copilot_person_id) references t_person;
alter table if exists t_flight add constraint FK_towplane_flight_id foreign key (towplane_flight_id) references t_flight;
alter table if exists t_flight add constraint FK_glider_flight_id foreign key (glider_flight_id) references t_flight;