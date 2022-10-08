SELECT
  capacity,
  num_bikes_available,
  (capacity - num_bikes_available) bikes_in_use,
  (num_bikes_available / capacity) available_ratio
FROM
  `second-hold-364806.nyc_citi_bike_trips.citibike_stations`
WHERE
  CAPACITY > 0
  AND num_bikes_available > 0

-- Sample Result
-- | capacity   | num_bikes_available   | bikes_in_use  | available_ratio      |
-- | 5          | 1                     | 4             |  0.2                 |
-- | 12         | 1                     | 11            | 0.083333333333333329 |