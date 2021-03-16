ARG VARIANT="15"
FROM mcr.microsoft.com/vscode/devcontainers/java:0-${VARIANT}

# Default MAVEN options
ARG INSTALL_MAVEN="false"
ARG MAVEN_VERSION=""

# MAVEN
RUN if [ "${INSTALL_MAVEN}" = "true" ]; then \
    su vscode -c "umask 0002 && . /usr/local/sdkman/bin/sdkman-init.sh && sdk install maven \"${MAVEN_VERSION}\""; \
    fi

# Default NODE options
ARG INSTALL_NODE="true"
ARG NODE_VERSION="lts/*"

# NODE
RUN if [ "${INSTALL_NODE}" = "true" ]; then \
    # Install NODE
    su vscode -c "umask 0002 && . /usr/local/share/nvm/nvm.sh && nvm install ${NODE_VERSION} 2>&1" && \
    # Install NODE packages.
    su vscode -c "source /usr/local/share/nvm/nvm.sh && npm install -g @angular/cli" 2>&1; \
    fi

# Copy check script
COPY check.sh /check.sh
RUN chmod +x /check.sh

# [Optional] Uncomment this section to install additional OS packages.
# RUN apt-get update && export DEBIAN_FRONTEND=noninteractive \
#     && apt-get -y install --no-install-recommends <your-package-list-here>
