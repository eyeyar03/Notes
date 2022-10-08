SELECT
  last_reported,
  DATE_ADD(last_reported, INTERVAL 3 DAY) dayP3,
  EXTRACT(YEAR FROM last_reported) year,
  EXTRACT(MONTH FROM last_reported) month,
  EXTRACT(DAY FROM last_reported) day
FROM
  `second-hold-364806.nyc_citi_bike_trips.citibike_stations`
ORDER BY
  last_reported DESC

-- Sample Result
-- | last_reported      | dayP3                 | year | month  | day   |
-- |2021-11-09T00:00:00 | 2021-11-12T00:00:00   | 2021 | 11     | 9     |