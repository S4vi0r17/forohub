CREATE TABLE topics (
                        id SERIAL PRIMARY KEY,
                        title VARCHAR(255) NOT NULL,
                        message TEXT NOT NULL,
                        creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        status VARCHAR(50) NOT NULL,
                        author VARCHAR(255) NOT NULL,
                        course VARCHAR(255) NOT NULL
);
