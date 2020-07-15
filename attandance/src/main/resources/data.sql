/* Roles */
insert into role (roleid, description, name) values (1, 'Lacerat unsp blood vessel at wrs/hnd lv of left arm, sequela', 'Attendee');
insert into role (roleid, description, name) values (2, 'Other non-in-line roller-skating accident, initial encounter', 'Extern');
insert into role (roleid, description, name) values (3, 'Burn of unspecified degree of unspecified elbow', 'Trainer');
insert into role (roleid, description, name) values (4, 'Lateral disloc of proximal end of tibia, left knee, init', 'Manager');
insert into role (roleid, description, name) values (5, 'Chronic serous otitis media, right ear', 'Admin');

/* Sponsors */
insert into sponsors (sponsorid, name) values (1, 'Twitterlist');
insert into sponsors (sponsorid, name) values (2, 'Thoughtblab');
insert into sponsors (sponsorid, name) values (3, 'Trudoo');

/* Companies */
insert into companies (companiesid, name) values (1, 'Station91');
insert into companies (companiesid, name) values (2, 'Crank');
insert into companies (companiesid, name) values (3, 'Other');

/* Addresses */
insert into addresses (addressesid, city, state, street, zip) values (1, 'Monroe', 'Louisiana', 'Claremont', '5');
insert into addresses (addressesid, city, state, street, zip) values (2, 'Santa Monica', 'California', 'Marcy', '98197');

/* Hall */
insert into hall (hallid, name, address_addressesid) values (1, 'Home Ing', 1);
insert into hall (hallid, name, address_addressesid) values (2, 'Latlux', 2);





