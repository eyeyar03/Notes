SELECT
  capacity,
  num_bikes_available,
  (capacity - num_bikes_available) bikes_in_use,
  CASE capacity
    WHEN 0 THEN NULL
  ELSE
  (num_bikes_available / capacity)
END
  safe_avail_capacity
FROM
  `second-hold-364806.nyc_citi_bike_trips.citibike_stations`

-- Sample Result
-- | capacity   | num_bikes_available   | bikes_in_use  | safe_avail_capacity   |
-- | 0          | 0                     | 0             | null                  |
-- | 14         | 0                     | 14            | 0                     |
-- | 5          | 1                     | 4             | 0.2                   |