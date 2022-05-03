# Docker

## `Docker run`
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


## `docker exec`
> Run a command in a running container

docker exec [OPTIONS] CONTAINER COMMAND [ARG...]

### Examples
| Example | Explanation |
| ------- | ----------- |
| `docker exec unruffled_easley cat /etc/hosts` | Execute cat command. |
| `docker exec -it unruffled_easley /bin/bash` | Get inside container. |
| `docker exec unruffled_easley ps -eaf` | List all processing on a container. |

## Other commands
| Command | Explanation |
| ------- | ----------- |
| `docker pull IMAGE` | Pull an image. Example: `docker pull nginx` |
| `docker images` | List all images. |
| `docker rmi IMAGE` | To remove image. Exanple: `docker rmi nginx` |
| `docker image prune -a` | Remove dangling images or images with no running containers. |
| `docker ps` | List all containers |
| `docker ps -a` | List all containers (including stopped containers). |
| `docker stop CONTAINER` | To stop a running container. Example: `docker rm 80083514637e` |
| `docker rm CONTAINER` | To remove container. Example: `docker rm 80083514637e` |
| `docker logs CONTAINER` | See the logs of the container in the background. Example: `docker logs d1ee787e7070` |
| `docker attach CONTAINER` | Attach local standard input, output, and error streams to a running container. Example: `docker attach 80083514637e` |
| `docker inspect CONTAINER` | Additional details of the specific container. Check IPAddress and MacAddress assigned to container under `NetworkSettings > Networks > bridge` Example: `docker inspect hopeful_sanderson` |
| `docker login` | To login. |
| `docker -H=remote-docker-engine:2375` | Accessing Docker CLI from remote . Example: `docker -H=10.123.2.1:2375 run nginx` |
| `docker info | more` | Display information about Docker like what store driver is being used. |
| `docker history IMAGE` | Check how image was built. |
| `docker system df` | Actual space consumption on the disk of docker. |
| `docker system df -v` | Actual space consumption of each image on the disk. |

## Creating Image - Dockerfile
| FROM | Defines what the base OS should be. |
| RUN | Run a particular command on the base image (e.g. install dependencies) |
| EXPOSE | Expose port. |
| COPY | Copies file from the local system on to the docker image. |
| ENTRYPOINT | Allows us to specify a command that will be ran when the image is ran as a container. |

### Example
```
FROM Ubuntu
RUN apt-get update && apt-get -y install python
RUN pip install flask flask-mysql
COPY . /opt/source-code
ENTRYPOINT FLASK_APP=/opt/source-code/app.py flask run
```

### Commands
| Command | Explanation |
| ------- | ----------- |
| `docker build . -f Dockerfile -t <tagname>` | Building the image. Example `docker build . -f Dockerfile -t amacandili/my-custom-app` |
| `docker push <tagname>` | Make the image public in Dockerhub. Example `docker push amacandili/my-custom-app` |
| `docker run --entrypoint sleep IMAGE 10` | To override the ENTRYPOINT. Example `docker run --entrypoint sleep ubuntu-sleeper 10` |

### CMD vs ENTRYPOINT
#### CMD
- The default command to run, but can be overridden.
- `CMD ["sleep", "5"]` - The container will sleep for 5 seconds.
- `docker run IMAGE sleep 10` - Will override the `CMD ["5"]` and the container will sleep for 10 seconds instead.

#### ENTRYPOINT
- Similar to CMD but will just append the additional parameter provided in the command.
- `ENTRYPOINT ["sleep"]` - Will execute sleep command, but this will fail since there is no parameter.
- `docker run IMAGE 5` - 5 will be appended to ENTRYPOINT (i.e. `ENTRYPOINT ["sleep", "5"]`) and will execute sleep 5.

### CMD and ENTRYPOINT
- To establish a default (note: for  this to happen, specificy the CMD instruction and ENTRYPOINT as json/array format)
- `ENTRYPOINT ["sleep"]`
- `CMD ["5"]`
- `docker run IMAGE` - The 5 from CMD will be appeded to ENTRYPOINT (i.e. `ENTRYPOINT ["sleep", "5"]`)
- `docker run IMAGE 10` - The CMD will be overridden with 10 and 10 will be appeded to ENTRYPOINT  (i.e. `ENTRYPOINT ["sleep", "10"]`)


## Docker Compose
### docker-compose.yml
- Use "build" instead of "image" when asking docker to build an image from a source code.
- Version 1 of docker-compose: no assurance of the order of running the containers especially when handling dependencies.
- Version 2 and up - supports what's lacking in version 1.
	- Must specific the version (e.g. version: 2) at the top of the file.
	- Automatically creates a dedicated bridge network and attaches all containers to that new network. All containers are then able to communicate with others using each other's service name. No need to use/define links between containers.
	- Added new `depends_on` property. Specify start up order of container.
- Version 3. Similar with version 2. Support for Docker swarm.

`docker-compose up` To bring up entire application stack defined in docker compose.

### Example of linking containers
```
docker run -d --name=db postgres
docker run -d --name=result -p 5000:80 --link db:db result-app
docker run -d --name=worker --link db:db --link redis:redis worker	
docker run -d --name=redis redis
docker run -d --name=vote -p 5001:80 --link redis:redis voting-app
```
- Links both result-app container named result worker container named worker to postgres container named db.
- Also links container named worker to  redis container named redis.
- Links voting-app container named vote to container named redis.
- Port 80 of container named result is mapped to port 5000 of Dockerhost.
- Port 80 of container named vote is mapped to port 5001 of Dockerhost.
- All containers are running in detached mode.

## Tagging Images and Pushing to Custom Registry
| Command | Explanation |
| ------- | ----------- |
| `docker run -d -p 5000:5000 --restart=always --name my-registry registry:2` | Running a custom registry container from registry:2 image. |
| `docker image tag IMAGE localhost:<port>/IMAGE:<tag>` | Tagging images and pointing to custom registry. Example: `docker image tag nginx:latest localhost:5000/nginx:latest` |
| `docker push nginx:latest localhost:5000/nginx:latest` | Pushing to custom registry. |
| `curl -X GET localhost:5000/v2/_catalog` | To check the list of images pushed. Sample output: `{"repositories":["httpd","nginx"]}`|


## File System
```
/var
  |-lib
	|-docker
		|-aufs
		|-containers
		|-image
		|-volumes
```

## Volume
| Command | Explanation |
| ------- | ----------- |
| `docker volume create data_volume` | Creates data_volume folder under /`var/lib/docker/volumes` directory. |
| `docker run -v data_volume:/var/lib/mysql mysql` | Mount `data_volume` into `var/lib/mysql` folder inside the container. This is called volume mounting. |
| `docker run -v /data/mysql:/var/lib/mysql mysql` | Mount a different directory (i.e. not under `/var/lib/docker/volumes`). This will mount the `mysql` directory under `/data`. This is called bind mounting. |
| `docker run --mount type=volume,source=data_volume,target=/var/lib/mysql mysql` | New way of mounting. Preferred because it's verbose. Mount type is volume. |
| `docker run --mount type=bind,source=/data/mysql,target=/var/lib/mysql mysql` | New way of mounting. Preferred because it's verbose. Mount type is bind. |

## Networks (Bridge (default), None and Host)
| Driver | Description |
|-------- | ----------- |
| bridge | Bridge network is a private internal network created by Docker on the host. (172.17 series) |
| none | Containers are not attached to any network and do not have any access to the external network or other containers (isolated network). |
| host | - Takes out any network isolation between Dockerhost and docker container. - Cannot run multiple containers on the same host on the same port as the ports are now common to all containers in the host network. |

| Command | Explanation |
| ------- | ----------- |
| `docker network create --driver bridge --subnet 182.18.0.0/16 --gateway 182.18.0.1 custom-isolated-network-name` | Create internal network. |
| `docker network ls` | List all networks. |
| `docker network inspect <NETWORK_ID or NAME>` | Inspect network like the subnet configured. Example: `docker network inspect bridge` |


## Other Notes
 - Built-in DNS server always run ata address 127.0.0.11.
 
## Links
- https://github.com/mmumshad/simple-webapp-flask/blob/master/app.py
- https://github.com/mmumshad/simple-webapp-flask
- https://docs.docker.com/engine/reference/commandline/compose/
- https://docs.docker.com/config/containers/resource_constraints/
 

