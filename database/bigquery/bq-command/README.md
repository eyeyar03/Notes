# BigQuery Commands

> Initialize command line environment using the following command:

``` gcloud init```

## gsutil Commands

### Uploading File to Bucket

Command

``` gsutil cp {file-to-upload} gs://{bucket-name} ```

Example

``` gsutil cp file-1.csv gs://learnbq1936_upload_bucketapm ```

### Uploading Entire Directory to Bucket

Command

``` gsutil cp -r {source-directory} gs://{bucket-name} ```

Example

``` gsutil cp -r multiple-files/ gs://learnbq1936_upload_bucketapm ```

### Checking Files Uploaded to Bucket

Command

``` gsutil ls gs://{bucket-name} ```

Example

``` gsutil ls gs://learnbq1936_upload_bucketapm ```

## bq Commands

### List All Datasets in the Default Project

Command

``` bq ls ```

### Make Dataset

Command

``` bq mk {dataset-name} ```

Example

``` bq mk test_dataset ```

### Remove Dataset

Command

``` bq rm {dataset-name} ```

Example

``` bq rm test_dataset ```

### Look into Dataset

Command

``` bq ls {dataset-name} ```

Example

``` bq ls nyc_citi_bike_trips ```

### Check Details (e.g. Datatypes) of Tables

Command

``` bq show {dataset-name}.{table-name} ```

Example

``` bq show nyc_citi_bike_trips.citibike_stations ```

### Execute a SELECT Statement

Command

``` bq query '{select-statement}' ```

``` bq query --use_legacy_sql=false '{select-statement}' ```

*For multiline*

``` bq query \'{select-statement}' ```

``` bq query --use_legacy_sql=false \'{select-statement}' ```

Example

``` bq query 'SELECT COUNT(*) station_count FROM `second-hold-364806.nyc_citi_bike_trips.citibike_stations`' ```

``` bq query --use_legacy_sql=false 'SELECT COUNT(*) station_count FROM `second-hold-364806.nyc_citi_bike_trips.citibike_stations`' ```

> BigQuery supports 2 types of SQL statements - Standard and Legacy. By default bq command uses Legacy SQL.
