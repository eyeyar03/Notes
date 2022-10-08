# BigQuery

- Serverless data warehouse.
- Petabyte scale.
- Uses SQL but is not a relational database.
- Analytical database.
- Other features:
    - BigQuery ML
    - BigQuery BI Engine
    - BigQuery GIS

## Datasets and Tables

### Project

- Collection of resources.

### Datasets

Collection of tables and views.

### Tables

- Where we actually keep our data.
- Store data in columns, which have datatypes.

### Views

- Virtual tables that allow us to describe subsets or combination of tables in a very concise way.
- They don't store data, they only refer to data.

> Tables and views are parts of datasets. And datasets are parts of projects.

## Different Ways to Query Data

- Graphical User Interface (GUI)
    - aka BigQuery console.

- bq command

- Storage API
    - Python client libraries
    - Spark
    - Cloud Dataflow

## BigQuery Data Types

> Scalar types have one value. (Numeric, Time, Boolean, String, Byte)

### Numeric Types

- **Integer** - Numbers without fractional component. (e.g. 1)
- **Numeric** - Exact numeric value with 38 digits of precision and 9 decimal digits of scale. (e.g. 1.234)
- **Floating Point** - approximate numeric values with fractional components. (e.g. 3.14159265)

### Time Scalars

- **Date** - Calendar date independent of timezone. (e.g. 2022-12-31)
- **Datetime** - Date and time independent of timezone. (e.g. 2022-12-31T01:15:25)
- **Time** - Clock time. (e.g. 01:14:25)
- **Timestamp** - Absolute point in time. (e.g. 2022-12-31T01:15:25Z)

### Other Scalars

> Single unit values.

- **Boolean** - True/False.
- **String** - Variable length character data.
- **Bytes** - Variable length binary data.

### Data Types with Multiple Values

- **Records** (Or structures)
    - Container of ordered fields.
    - Fields have datatype and name.
    - Datatypes may vary within a struct.
- **Arrays**
    - Ordered list of values of the same data type.
    - Zero or more values.
    - Values any be scalars or struct data type.
    - Values may not be array data type.

## Component Services that Make Up BigQuery

### Replicated, Distributed Storage

#### Colossus

- Globally distributed file system which is a massive data store.
- 2nd generation global file system from Google. The 1st generation is called Google File System.
- Distributed storage system.
- Handles replication and recovery.
- No need to manage storage.

#### Cloud Spanner

- Globally scalable databases.
- For managing metadata about the data that we store in the query.

### High-Available Cluster Compute

#### Dremel

- A system that takes our SQL queries, breaks them down into distinct executable chunks, and then produces the results
  based on those chunks and merges the results and delivers the results to us. And it does this by creating or deploying
  this work in jobs and a job is an abstraction for running a query or other operations within BigQuery.
- Multi-tenant cluster. Runs SQL queries for different users.
- SQL queries to execute trees.
    - Leaves are called slots; read data and perform computation.
    - Inner nodes perform aggregation.
- Dynamically allocate slots to queries.
- Maintain fairness.
- Single user cloud get thousands of slots.

#### Borg

- The system that manages job.
- Manages mixers and slots.
- Predecessor of Kubernetes. (A lot of ideas that were developed in Borg kind of influenced the design of Kubernetes as
  well.)

### Jupiter Network (Petabit Network)

- The key to successfully decoupling storage and compute.
- Quickly move data between storage and compute. Very fast at moving data between Colossus and Spanner and Dremel and
  Borg.
- A network hardware that has been developed by Google which provides for petabyte scale throughput in the network.
- Google networking switch.
- No need for rack awareness.

## Columnar Format

### Capacitor

- Columnar storage format.
- Supports semi-structured data.
    - Nested structures.
    - Repeated fields.
- No need to read parent column to produce a nested structure attribute value.
- Compression.

## Partitioning

### Partitioned Tables

- Table is divided into segments called partitions.
- Improves query performance.
- Lowers cost by reducing amount of data scanned.

### 3 Ways to Partition Data

1. Partition by Ingestion Time

- Loads data into daily, date-based partitions.
- Automatically creates new partitions.
- Uses ingestion time to determine partition.
- Creates pseudo-column_PARTITIONTIME.
    - Date-based timestamp.
    - Used in queries to limit the number of partitions scanned.

2. Date/Timestamp Partitioning

- Partition based on date or timestamp column.
- Each partition holds one day of data.
- No need for _PARTITIONTIME column.
- Special partitions
    - NULL when nulls in partition column.
    - UNPARTITION when values in column are outside allowed range.

3. Integer Range Partitioning

- Partition column must be an integer type.
- Partition column cannot be repeated. (i.e. needs to be a scalar)
- Cannot use Legacy SQL to query partitioned tables.

## Sharding vs Partitioning

### Sharding

- Uses separate table for each day.
- Uses UNION in queries to scan multiple tables.

### Partitioning

- In BigQuery partitioning is preferred over sharding.
- Uses one table but breaks things up within the table into partitions. Sharding break things up into separate tables.
- Less metadata to maintain.
- Less permission checking overhead.
- Better performance.

## Requiring Partition Filter

- Require_partition_filter parameter.
- Specified at table level (formerly at partition level).
- Requires a WHERE clause with the partition column.

## Clustering

Clustering is another technique used in BigQuery to improve performance.

### Clustered Tables

- Data sorted based on values in one or more columns.
- Can improve performance of aggregate queries.
- Can reduce scanning when cluster columns are used in WHERE clause.

### Automatic Reclustering

As new data is added to a table, data may be stored out of order. BigQuery automatically re-clusters in the background.

## Performance Tuning

### Data Modeling Tips

- BigQuery is designed for scanning in parallel.
- Partition to minimize amount of data scanned.
- Cluster to further reduce the amount of data scanned.
- Joins may require shuffling data across slots so denormalize using nested and repeated fields to avoid needing joins.

## Notes

- [Introduction to Google Cloud BigQuery](https://cognizant.udemy.com/course/introduction-to-google-cloud-bigquery/learn/lecture/32177922#overview)
- [BigQuery](https://cloud.google.com/bigquery)
- [BigQuery Explained](https://cloud.google.com/blog/products/data-analytics/new-blog-series-bigquery-explained-overview)
- [Component Services that Make Up BigQuery](https://cloud.google.com/blog/products/data-analytics/cloud-data-warehouse-bigquery-4-9s-sla)
- [Google File System](https://en.wikipedia.org/wiki/Google_File_System#/media/File:GoogleFileSystemsGFS.svg)
- [Aggregate Functions](https://cloud.google.com/bigquery/docs/reference/standard-sql/aggregate_functions)
- [Mathematical Functions](https://cloud.google.com/bigquery/docs/reference/standard-sql/mathematical_functions)
- [String Functions](https://cloud.google.com/bigquery/docs/reference/standard-sql/string_functions)
- [gcloud CLI](https://cloud.google.com/sdk/docs/install)