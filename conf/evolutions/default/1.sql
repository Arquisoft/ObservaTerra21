# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table Area (
  id                        integer not null,
  nombre                    varchar(255),
  constraint pk_Area primary key (id))
;

create table Indicator (
  id                        bigint not null,
  indicador                 varchar(255),
  constraint pk_Indicator primary key (id))
;

create table Measure (
  id                        bigint not null,
  medida                    varchar(255),
  unidad                    varchar(255),
  constraint pk_Measure primary key (id))
;

create table Observation (
  id                        bigint not null,
  area_id                   integer,
  indicator_id              bigint,
  measure_id                bigint,
  time_id                   bigint,
  provider_id               integer,
  observation_value         double,
  constraint pk_Observation primary key (id))
;

create table Organization (
  id                        integer not null,
  nombre                    varchar(255),
  constraint pk_Organization primary key (id))
;

create table pertenece (
  id                        integer not null,
  usuario_id                integer,
  org_id                    integer,
  constraint pk_pertenece primary key (id))
;

create table Time (
  id                        bigint not null,
  comienzo                  timestamp,
  fin                       timestamp,
  constraint pk_Time primary key (id))
;

create table User (
  id                        integer not null,
  usuario                   varchar(255),
  password                  varchar(255),
  mail                      varchar(255),
  nombre                    varchar(255),
  apellidos                 varchar(255),
  constraint pk_User primary key (id))
;

create sequence Area_seq;

create sequence Indicator_seq;

create sequence Measure_seq;

create sequence Observation_seq;

create sequence Organization_seq;

create sequence pertenece_seq;

create sequence Time_seq;

create sequence User_seq;

alter table Observation add constraint fk_Observation_area_1 foreign key (area_id) references Area (id) on delete restrict on update restrict;
create index ix_Observation_area_1 on Observation (area_id);
alter table Observation add constraint fk_Observation_indicator_2 foreign key (indicator_id) references Indicator (id) on delete restrict on update restrict;
create index ix_Observation_indicator_2 on Observation (indicator_id);
alter table Observation add constraint fk_Observation_measure_3 foreign key (measure_id) references Measure (id) on delete restrict on update restrict;
create index ix_Observation_measure_3 on Observation (measure_id);
alter table Observation add constraint fk_Observation_time_4 foreign key (time_id) references Time (id) on delete restrict on update restrict;
create index ix_Observation_time_4 on Observation (time_id);
alter table Observation add constraint fk_Observation_provider_5 foreign key (provider_id) references Organization (id) on delete restrict on update restrict;
create index ix_Observation_provider_5 on Observation (provider_id);
alter table pertenece add constraint fk_pertenece_usuario_6 foreign key (usuario_id) references User (id) on delete restrict on update restrict;
create index ix_pertenece_usuario_6 on pertenece (usuario_id);
alter table pertenece add constraint fk_pertenece_org_7 foreign key (org_id) references Organization (id) on delete restrict on update restrict;
create index ix_pertenece_org_7 on pertenece (org_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists Area;

drop table if exists Indicator;

drop table if exists Measure;

drop table if exists Observation;

drop table if exists Organization;

drop table if exists pertenece;

drop table if exists Time;

drop table if exists User;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists Area_seq;

drop sequence if exists Indicator_seq;

drop sequence if exists Measure_seq;

drop sequence if exists Observation_seq;

drop sequence if exists Organization_seq;

drop sequence if exists pertenece_seq;

drop sequence if exists Time_seq;

drop sequence if exists User_seq;

