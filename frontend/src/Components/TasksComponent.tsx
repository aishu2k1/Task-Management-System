import {GridCol, Grid, Badge, ScrollArea, Stack, Checkbox, Space, Group, HoverCard, Button, Text, Modal, Combobox, useCombobox, InputBase, Input, TextInput } from '@mantine/core';
import { useForm } from '@mantine/form';
import { useDisclosure } from '@mantine/hooks';
import { useState, useEffect } from 'react';


interface Category {
    name: string;
}

const toDoTasksData = [
    {
        title: "some task to perform",
        desc: "description of the task"
    },
    {
        title: "some task to perform",
        desc: "description of the task"
    },
    {
        title: "some task to perform",
        desc: "description of the task"
    },
    {
        title: "some task to perform",
        desc: "description of the task"
    },
    {
        title: "some task to perform",
        desc: "description of the task"
    },
    {
        title: "some task to perform",
        desc: "description of the task"
    },
    {
        title: "some task to perform",
        desc: "description of the task"
    },
] 

const inProgressTasksData = [
    {
        title: "some task to perform",
        desc: "description of the task"
    },
    {
        title: "some task to perform",
        desc: "description of the task"
    },
]

const completedTasks = [
    {
        title: "some task to perform",
        desc: "description of the task"
    },
    {
        title: "some task to perform",
        desc: "description of the task"
    },
]

export function TasksComponent() {
    const [openedCreateTask, { open, close }] = useDisclosure(false);
    const [categories, setCategories] =  useState<Category[]>([]);
    useEffect(() => {
      const fetchData = async () => {
        try {
            const response = await fetch('http://localhost:8080/users/root/categories');
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            const jsonData = await response.json();
            setCategories(jsonData); 
            console.log(categories)
        } catch (err) {
            console.error('Error fetching data:', err);
        }
        };
        fetchData()
    }, [])

    const combobox = useCombobox({
        onDropdownClose: () => combobox.resetSelectedOption(),
      });
    
    const [value, setValue] = useState<string | null>(null);

    const form = useForm({
        mode: 'uncontrolled',
        initialValues: {
          taskName: '',
          taskDescription: '',
          taskCategory: '',
        }})

    return (
        <>
            <ScrollArea h={800}>
                <Grid pl={20}>
                    <Grid.Col span={4}>
                        <Stack>
                        <Badge color="pink.7" size="xl">To Do</Badge>
                        <Space h={10}></Space>
                        {
                            toDoTasksData.map((item, index) => (
                                // <Checkbox defaultChecked size='lg' label={item.title} description={item.desc}/>
                                <Group justify='flex-start'>
                                <HoverCard width={280} shadow="md" openDelay={700}>
                                    <HoverCard.Target>
                                    <Group>
                                    <Checkbox size='lg' label={item.title}/>
                                    </Group>
                                    </HoverCard.Target>
                                    <HoverCard.Dropdown>
                                    <Text size="sm">
                                        {item.desc}
                                    </Text>
                                    </HoverCard.Dropdown>
                                </HoverCard>
                                </Group>
                            ))
                        }
                        </Stack>
                    </Grid.Col>
                    <Grid.Col span={4}>
                        <Stack>
                        <Badge color="blue.7" size="xl">In Progress</Badge>
                        <Space h={10}></Space>
                        {
                            inProgressTasksData.map((item, index) => (
                                // <Checkbox defaultChecked size='lg' label={item.title} description={item.desc}/>
                                <Group justify='flex-start'>
                                <HoverCard width={280} shadow="md" openDelay={700}>
                                    <HoverCard.Target>
                                    <Group>
                                    <Checkbox size='lg' label={item.title}/>
                                    </Group>
                                    </HoverCard.Target>
                                    <HoverCard.Dropdown>
                                    <Text size="sm">
                                        {item.desc}
                                    </Text>
                                    </HoverCard.Dropdown>
                                </HoverCard>
                                </Group>
                            ))
                        }
                        </Stack>
                    </Grid.Col>
                    <Grid.Col span={4}>
                        <Stack>
                        <Badge color="green.7" size="xl">Completed</Badge>
                        <Space h={10}></Space>
                        {
                            completedTasks.map((item, index) => (
                                // <Checkbox defaultChecked size='lg' label={item.title} description={item.desc}/>
                                <Group justify='flex-start'>
                                <HoverCard width={280} shadow="md" openDelay={700}>
                                    <HoverCard.Target>
                                    <Group>
                                    <Checkbox size='lg' label={item.title}/>
                                    </Group>
                                    </HoverCard.Target>
                                    <HoverCard.Dropdown>
                                    <Text size="sm">
                                        {item.desc}
                                    </Text>
                                    </HoverCard.Dropdown>
                                </HoverCard>
                                </Group>
                            ))
                        }
                        </Stack>
                    </Grid.Col>
                </Grid>
            </ScrollArea>

            <Modal opened={openedCreateTask} onClose={close} title="Add a new Task" centered>
            <form onSubmit={form.onSubmit((values) => console.log(values))}>
            <TextInput withAsterisk label="Name" key={form.key('taskName')} {...form.getInputProps('taskName')}/>
            <Space h={10}/>
            <TextInput withAsterisk label="Description" key={form.key('taskDescription')} {...form.getInputProps('taskDescription')}/>
            <Space h={10}/>
            <Combobox
                store={combobox}
                onOptionSubmit={(val) => {
                    setValue(val);
                    combobox.closeDropdown();
                }}
                >
                <Combobox.Target>
                    <InputBase
                    component="button"
                    type="button"
                    pointer
                    rightSection={<Combobox.Chevron />}
                    rightSectionPointerEvents="none"
                    onClick={() => combobox.toggleDropdown()}
                    label="Category"
                    withAsterisk
                    key={form.key('taskCategory')}
                    {...form.getInputProps('taskCategory')}
                    >
                    {value || <Input.Placeholder>Pick value</Input.Placeholder>}
                    </InputBase>
                </Combobox.Target>

                <Combobox.Dropdown>
                    {
                        categories.map((item, index) => (
                            <Combobox.Options>{item.name}</Combobox.Options>
                        ))
                    }
                </Combobox.Dropdown>
                </Combobox>
                <Group justify="flex-end" mt="md">
                    <Button type="submit">Submit</Button>
                </Group>
                </form>
            </Modal>

            <Group justify='flex-end'>
                <Button mt={10} mr={10} variant="outline" onClick={open}>Add Task</Button>
          </Group>
        </>
    )
}