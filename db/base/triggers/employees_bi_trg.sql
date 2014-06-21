CREATE OR REPLACE TRIGGER employees_bi_trg 
	before insert on employees
	referencing new as new old as old
	for each row
declare

begin
	if inserting then
    :new.id := global_seq.nextval;
end if;
end;
/