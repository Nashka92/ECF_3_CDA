FROM node:14 AS builder
WORKDIR /app


COPY package.json package-lock.json* ./
RUN npm install


COPY .env .env
COPY . .


RUN npm run build


FROM node:14
WORKDIR /app

COPY package.json package-lock.json* ./
RUN npm install --only=production


COPY --from=builder /app/build ./build
COPY server.js .

EXPOSE 3000

CMD ["node", "server.js"]


