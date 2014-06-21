create or replace 
trigger manufacturer_bi_trg
	before insert on manufacturer
	referencing new as new old as old
	for each row
declare

begin
	if inserting then
	:new.id := global_seq.nextval;
	end if;
end;