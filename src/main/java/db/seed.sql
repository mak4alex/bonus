USE souvenirstore;


INSERT INTO producers (name, country) VALUES
	('Producer 1', 'Belarus'),
    ('Producer 2', 'Poland'),
    ('Producer 3', 'Belarus'),
    ('Producer 4', 'Russia'),
    ('Producer 5', 'Poland'),
    ('Producer 6', 'Belarus'),
    ('Producer 7', 'Russia'),
    ('Producer 8', 'Poland'),
    ('Producer 9', 'Belarus'),
    ('Producer 10', 'Russia');
    

INSERT INTO souvenirs (name, made_date, price, producer_id) VALUES
	('Souvenir 1', '2014-01-01', 78.2, 1),
    ('Souvenir 2', '2014-02-01', 28.2, 1),
    ('Souvenir 3', '2014-03-01', 38.2, 1),
    ('Souvenir 4', '2014-04-03', 18.2, 1),
    ('Souvenir 5', '2014-05-04', 43.2, 1),
    ('Souvenir 6', '2014-06-01', 58.2, 2),
    ('Souvenir 7', '2014-07-01', 78.2, 2),
    ('Souvenir 8', '2014-08-03', 43.2, 2),
    ('Souvenir 9', '2014-09-01', 78.2, 3),
    ('Souvenir 10', '2014-01-03', 54.2, 3),
    ('Souvenir 11', '2014-04-01', 78.2, 4),
    ('Souvenir 12', '2014-07-13', 34.2, 4),
    ('Souvenir 13', '2014-09-14', 78.2, 5),
    ('Souvenir 14', '2014-03-01', 43.2, 6),
    ('Souvenir 15', '2014-01-24', 78.2, 7),
    ('Souvenir 16', '2014-01-01', 754.2, 7),
    ('Souvenir 17', '2014-01-01', 23.2, 8),
    ('Souvenir 18', '2014-03-21', 47.2, 9),
    ('Souvenir 19', '2014-04-01', 76.2, 9),
    ('Souvenir 20', '2014-03-11', 43.2, 10),
    ('Souvenir 21', '2014-06-05', 34.2, 10);
