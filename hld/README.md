# High Level Design (HLD) Interview Prep

## Core Concepts
- Horizontal vs vertical scaling
- Load balancing (round robin, least connections, consistent hashing)
- Caching (write-through, write-back, write-around, eviction: LRU, LFU, TTL)
- CDN
- SQL vs NoSQL (when to use which)
- Database indexing (B-tree, LSM tree)
- Database replication (master-slave, multi-master)
- Database sharding (range, hash, directory)
- CAP theorem
- Consistency models (strong, eventual, causal)
- ACID vs BASE

## Estimation
- Back-of-envelope calculations
- QPS, storage, bandwidth estimation
- Read/write ratio analysis

## Communication
- REST vs gRPC vs GraphQL
- WebSockets vs long polling vs SSE
- Message queues (Kafka, RabbitMQ, SQS)
- Pub/sub pattern

## Infrastructure
- Microservices vs monolith
- API gateway
- Service discovery
- Circuit breaker
- Rate limiting (token bucket, leaky bucket, sliding window counter)
- Distributed tracing
- Observability (metrics, logs, traces)

## BBG Vol 1 Questions (self-design 30 min before reading)
- [ ] Rate Limiter
- [ ] Key-Value Store
- [ ] Unique ID Generator
- [ ] URL Shortener
- [ ] Web Crawler
- [ ] Notification System
- [ ] News Feed System
- [ ] Chat System
- [ ] Search Autocomplete
- [ ] YouTube
- [ ] Google Drive

## BBG Vol 2 Questions (never skip: Payment System, Message Queue, S3, Ad Click)
- [ ] Proximity Service
- [ ] Nearby Friends
- [ ] Google Maps
- [ ] Distributed Message Queue
- [ ] Metrics Monitoring
- [ ] Ad Click Aggregation
- [ ] Hotel Reservation
- [ ] Distributed Email Service
- [ ] S3-like Object Storage
- [ ] Real-time Gaming Leaderboard
- [ ] Payment System
- [ ] Digital Wallet
- [ ] Stock Exchange

## AI-Flavored HLD (showing up in 2026 loops)
- RAG pipeline design
- LLM gateway (rate limiting, cost routing, caching)
- AI chatbot infrastructure
- Vector database design
- Embedding + retrieval service
