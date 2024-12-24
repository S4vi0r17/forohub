ALTER TABLE topics
    ADD CONSTRAINT unique_title_message UNIQUE (title, message);
