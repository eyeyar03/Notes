# Docker

## Docker run
> Run a container from an image.

`docker run [OPTIONS] IMAGE [COMMAND] [ARG...]`

### Options
| Option | Description |
| ------ | ------------|
|`-d`|detached mode|
|`-e` |set environment variables|
|`-i`|interactive|
|`--mount`|attach a filesystem mount to the container|
|`--name`|assign a name to a container|
|`-p`|port mapping|
|`-t`|psuedo terminal (tty)|
|`-v`|volume mounting|


### Examples
| Example | Explanation |
| ------- | ----------- |
| `docker run ubuntu` | Attached mode. |
| `docker run -d ubuntu` | Detached mode. |
| `docker run --name=db postgres` | To name a container. |
| `docker run ubuntu sleep 5` | Ask Docker to run a process (i.e. sleep) for 5 seconds. |
| `docker run -p 80:5000 webapp` | Port mapping. Map port 5000 of container to port 80 of Dockerhost. |
| `docker run -p 80:5000 --link db:db webapp` | Link `webapp` to running instance of postgress named `db`. Link is deprecated. |
| `docker run -v data_volume:/var/lib/mysql mysql` | Volume mounting. Mount `data_volume` of Dockerhost into `/var/lib/mysql` folder inside the container. Note that `data_volume` is under `/var/lib/docker/volumes`. |
| `docker run -v /data/mysql:/var/lib/mysql mysql` | Bind mounting / Mount a different directory. Mount `mysql` directory under `/data` of Dockerhost into `/var/lib/mysql` folder inside the container. Note that `/data/mysql` is not under `/var/lib/docker/volumes`. |
| `docker run --mount type=bind,source=/data/mysql,target=/var/lib/mysql mysql` | Newer way of mounting. Preferred because it's verbose. |
| `docker run -e APP_COLOR=blue simple-webapp-color` | Supply or set environment variables (i.e. COLOR) |
| `docker run -i ubuntu` | Interactive mode. |
| `docker run -it centos bash` | Login directly to container. |
| `docker run redis:4.0` | To run a specific tag of image (i.e. 4.0). "latest" is the default tag used by Docker. |
| `docker run ubuntu --network=bridge`| Same as `docker run ubuntu`. Default network is bridge. |
| `docker run --cpu=.5 ubuntu` | Limits Dockerhost's CPU usage of container up to 50%. |
| `docker run --memory=100m ubuntu` | Limits Dockerhost's memory usage of container up to 100 megabytes. |
| `docker run -d -p 5000:5000 --restart=always --name my-registry registry:2` | Running a custom registry container from registry:2 image. |
| `docker -H=10.123.2.1:2375 run nginx` | Accessing Docker CLI from remote. |


