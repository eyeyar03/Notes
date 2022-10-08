SELECT
  start_station_id,
  ROUND(AVG(tripduration), 2) avg_duration
FROM
  `second-hold-364806.nyc_citi_bike_trips.citibike_trips`
WHERE
  start_station_id > 100
GROUP BY
  start_station_id
ORDER BY
  start_station_id ASC

-- Sample Result
-- | start_station_id   | avg_duration  |
-- | 116                | 754.36        |