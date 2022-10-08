SELECT
  name,
  station_id,
  CONTAINS_SUBSTR(name, '&') is_corner,
  SUBSTR(name, 5, 10) sname,
  name || '-' || station_id n_station_id
FROM
  `second-hold-364806.nyc_citi_bike_trips.citibike_stations`

-- Sample Result
-- | name           | station_id    | is_corner | sname         | n_station_id       |
-- | 6 Ave & 17 St  | 4344          | true      | e & 17 St     | 6 Ave & 17 St-4344 |
-- | Great Jones St | 229           | false     | t Jones St    | Great Jones St-229 |