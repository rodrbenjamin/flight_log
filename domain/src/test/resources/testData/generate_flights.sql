-- generovani letu

insert into t_flight(id, flight_type, club_airplane_id, takeoff_time, landing_time, task, pilot_person_id, note)
SELECT
       nextval('seq_flight'),
       'TOWPLANE',
       floor(random()*(2-1+1))+1, -- generuje ID uzivatele od 1 do 2
       (TIMESTAMP '2016-10-23 13:30:00'),
       (TIMESTAMP '2016-10-23 13:35:00'),
       'VLEK',
       floor(random()*(2-1+1))+1, -- generuje ID klubovych letadel od 1 do 2
       'Generated note ' || seq
FROM GENERATE_SERIES(1, 50000) seq;