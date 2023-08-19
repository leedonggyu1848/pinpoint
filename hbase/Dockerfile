FROM openjdk:8u342-slim

# github repository에서 가져올 버전
ARG PINPOINT_VERSION=${PINPOINT_VERSION:-2.5.2}
# apache 아카이브 사이트에서 가져올 버전
ARG HBASE_VERSION=${HBASE_VERSION:-1.2.6}
ENV HBASE_REPOSITORY=http://apache.mirrors.pair.com/hbase
ENV HBASE_SUB_REPOSITORY=http://archive.apache.org/dist/hbase

ENV BASE_DIR=/opt/hbase
ENV HBASE_HOME=${BASE_DIR}/hbase-${HBASE_VERSION}

COPY /scripts/initialize-hbase.sh /usr/local/bin/
COPY /scripts/check-table.sh /usr/local/bin/

RUN apt-get update && apt-get install --no-install-recommends -y curl && apt-get clean \
    && chmod 777 /usr/local/bin/initialize-hbase.sh \
    && chmod 777 /usr/local/bin/check-table.sh \
    && mkdir -p ${BASE_DIR} \
    && cd ${BASE_DIR} \
    && curl -fSL "${HBASE_REPOSITORY}/${HBASE_VERSION}/hbase-${HBASE_VERSION}-bin.tar.gz" -o hbase.tar.gz || curl -fSL "${HBASE_SUB_REPOSITORY}/${HBASE_VERSION}/hbase-${HBASE_VERSION}-bin.tar.gz" -o hbase.tar.gz \
    && tar xfvz hbase.tar.gz \
    && curl -SL "https://raw.githubusercontent.com/pinpoint-apm/pinpoint/v${PINPOINT_VERSION}/hbase/scripts/hbase-create.hbase" -o ${BASE_DIR}/hbase-create.hbase

VOLUME ["/home/pinpoint/hbase", "/home/pinpoint/zookeeper"]

CMD /usr/local/bin/initialize-hbase.sh && tail -f /dev/null
