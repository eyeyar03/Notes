INSERT INTO `second-hold-364806.bicycles.available_bicycles`
(bicycle_id, color,manufacturer)
VALUES
  (3, 'black', 'Racing Bicycles');

UPDATE `second-hold-364806.bicycles.available_bicycles`
SET color = 'green'
WHERE color = 'red';


DELETE FROM `second-hold-364806.bicycles.available_bicycles`
WHERE color = 'green';